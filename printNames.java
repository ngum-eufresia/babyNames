
/**
 * Write a description of printNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu .duke.*;   
import org.apache.commons.csv.*;
public class printNames {
    int newborn=0;
    public void printAllNames(){
      FileResource fr= new FileResource();
      for(CSVRecord  rec : fr.getCSVParser(false)){
        int numBorn = Integer.parseInt(rec.get(2));
       // int size=rec.size();
         if(numBorn>newborn){
            newborn=numBorn;
            System.out.println("name "+rec.get(0) + "Gender "+ rec.get(1) + "Num born " +rec.get(2));
        }
          //System.out.println("size " + size);
    }

        
       System.out.println("largest born equals  "+ newborn);
     
}   

   public void totalBirths(){ 
       FileResource  fr = new FileResource();
       int girls=0;
       int boys=0;
       int totalNum=0;
      for(CSVRecord  rec : fr.getCSVParser(false)){
         int numBorn = Integer.parseInt(rec.get(2));
         totalNum+=numBorn;
         
         if (rec.get(1).trim().equalsIgnoreCase("M")){
            boys++;
        }
        else
            if (rec.get(1).trim().equalsIgnoreCase("F")){
             girls++;
            }
            else{
            System.out.println("no sex found");
        }
   } 

System.out.println("number of boys  "+boys);
   System.out.println("number of girls "+girls);
   System.out.println("total number  "+  totalNum);
}
public int getCount(String name,String gender){
  FileResource fr= new FileResource();      
  int count=-1;
      for(CSVRecord  rec : fr.getCSVParser(false)){  
       String myName= rec.get(0);
       String myGender =rec.get(1);
       if(myName.equalsIgnoreCase(name)&& myGender.equalsIgnoreCase(gender)){
           count = Integer.parseInt(rec.get(2));
           break;
          } 
        }
        System.out.println("count equals   " + count);
   return count;
}




public int getCount1(String gender){
  FileResource fr= new FileResource();      
  int count=-1;
      for(CSVRecord  rec : fr.getCSVParser(false)){  
       String myName= rec.get(0);
       String myGender =rec.get(1);
       if(myGender.equalsIgnoreCase(gender)){
           count = Integer.parseInt(rec.get(2));
           break;
          } 
        }
   return count;
}
public int getCountByFile(String name,String gender,File f){
  FileResource fr= new FileResource(f);
  int count=-1;
      for(CSVRecord  rec : fr.getCSVParser(false)){  
       String myName= rec.get(0);
       String myGender =rec.get(1);
       if(myName.equalsIgnoreCase(name)&& myGender.equalsIgnoreCase(gender)){
           count = Integer.parseInt(rec.get(2));
           break;
          }
        }
        System.out.println("count equals   " + count);
   return count;
}
   public int getRank(int year,String name,String gender){
      int count1=0;
      int prev=0;
      int pres=0;
      int freq=getCount(name,gender);
       if(freq==-1){
           System.out.println("answer is -1");
        }
        
          
      FileResource fr= new FileResource();
      for(CSVRecord  rec : fr.getCSVParser(false)){ 
        int numBorn = Integer.parseInt(rec.get(2));
        String myName= rec.get(0);
        String getGender=rec.get(1);
        
        if(numBorn >= freq && gender.equalsIgnoreCase(getGender)){
        System.out.println("number of born" +  numBorn );
        count1++;
        } 
        
        if(myName.equalsIgnoreCase(name)){
            break;
}

    
    
}

     int Rank=count1; 
     
    // System.out.println("rank equals" + Rank);
     return Rank;
   
} 









   public int getRank1(int year,String gender){
      int count1=0;
      int prev=0;
      int pres=0;
      int freq1=getCount1(gender);
       if(freq1==-1){
           System.out.println("answer is -1");
        }
     
       
      FileResource fr= new FileResource();
      for(CSVRecord  rec : fr.getCSVParser(false)){ 
        int numBorn = Integer.parseInt(rec.get(2));
        String myName= rec.get(0);
        String getGender=rec.get(1);
        
        if(numBorn >= freq1 && gender.equalsIgnoreCase(getGender)){
        //System.out.println("number of born" +  numBorn );
        count1++;
        } 
        
        if(myName.equalsIgnoreCase(rec.get(0))){
            break;
}
    
    
}

     int Rank=count1; 
     
    // System.out.println("rank equals" + Rank);
     return Rank;
}
   public int getRankByFile(int year,String name,String gender, File f){
  
    
     /* int freq=getCountByFile(name,gender,f);
       if(freq==-1)
           System.out.println("answer is -1");
        
      */ 
      int count1=0; 
      FileResource fr= new FileResource(f); 
       int freq=getCountByFile(name,gender,f);
       if(freq==-1){
           System.out.println("answer is -1");
     // do{
        }
      for(CSVRecord  rec : fr.getCSVParser(false)){
        int numBorn = Integer.parseInt(rec.get(2));
        String myName= rec.get(0);
        String getGender=rec.get(1);
        if(numBorn>=freq && gender.equalsIgnoreCase(getGender)){
        count1++;
     
        }
       
      
     
       if(myName.equalsIgnoreCase(name)){
            break;
        }
      }
   // }
    //while(myName.equalsIgnoreCase(name));
     int Rank=count1 ; 
     
     System.out.println("rank equals" + Rank);
     return Rank;
}
public String getName(int year,int rank,String gender){
    FileResource fr= new FileResource(); 
   
    CSVRecord row=null;
    int largestSoFar=Integer.MAX_VALUE;
      int largestRow=-1; 
       for(int i=0; i<rank;i++){
          int k=0; 
          int closest=0;
          int rowNum=0;
       for(CSVRecord  rec : fr.getCSVParser(false)){
          String myGender =rec.get(1);
          if(myGender.equalsIgnoreCase(gender)){
            int number=Integer.parseInt(rec.get(2));
            if(number<=largestSoFar && number>closest && k>largestRow){
                
           closest=number;
           rowNum=k;
           row=rec;            
            }
        
        }
         k++; 
    }  
      largestSoFar=closest;
      largestRow=rowNum;
      
   
     }
     System.out.println("row equals   "  + row.get(0));
     return row.get(0); 
    
    
}   
public int yearOfHighestRank(String name, String gender){
 int highestRank=0;
 int count;
 
     DirectoryResource dr = new DirectoryResource();
     for(File f:dr.selectedFiles()){
      int freq=getCountByFile(name,gender,f);
      if(freq==-1){
        System.out.println("that name not found");
       
    } else{
      int year=1980;
      int rank=getRankByFile(year,name, gender,f);
      System.out.println( " the rank of name equals  " + rank  );
      // System.out.println("name of file " + f.getPath());
      if(rank>highestRank){
          
        highestRank=rank;
        System.out.println("name of file " + f.getPath());
        }
         if(rank==highestRank){
          
        rank=rank;
        System.out.println("name of file " + f.getPath());
    }
}
}
   return highestRank;
     }
     
public double getAverageRank(String name, String gender){
    double count=0;
    double sum=0;
    double average=0;
    int rank=0;
  DirectoryResource dr=new DirectoryResource();
  for(File f : dr.selectedFiles()){
     int freq=getCountByFile(name,gender,f);
     if(freq==-1){  
         
    System.out.println("name not found");
    
    }
    else{
     //System.out.println("freq= " + freq);
     int year=1980;
     rank=getRankByFile(year,name, gender,f);
     System.out.println("  the rank of this partticular file for which we are looking for the average is  "+ rank);
     count++;
     sum+=rank;
    
    
  average=sum/count;
  System.out.println("average equals "+ average);
  }
}
  return average; 
} 
public void rankHigherThan(int year, String name, String gender){
    year=1980;
    int rank=0;
    int numBorn=0;
    int freq1=0;
    int count1=0;
    String myName= "";
    int Rank=getRank(year, name, gender);
    
    System.out.println(" the rank of  this partcular name equals"  +  Rank);
    CSVRecord row=null;
    FileResource fr= new FileResource(); 
   for(CSVRecord  rec : fr.getCSVParser(false)){ 
       //numBorn = Integer.parseInt(rec.get(2));
      // myName=rec.get(0);
       int Rank1=getRank1(year, gender);
        
      if(Rank1>Rank){
        freq1+=count1;
        
       // if(myName.equalsIgnoreCase(rec.get(0))){
          // break;
        
 
   System.out.println("total births higher than rank pesently "+ freq1);
    }
} 

       
       
    // System.out.println(" total number ranked greater than freqs    " + freq1);
    }

    
    /*
    public void testRankbyfile(){
        int myRank= getRankByFile( 2012,"Owen","M");
        
 
     System.out.println("final rank equal "+ myRank);

    
    }
*/
public void testCount(){
  int getcount = getCount("Margaret", "F");
  
}
public void testRank(){
        int myRank= getRank( 1922,"Emily" ,"F");
        
 
     System.out.println("final rank equal "+ myRank);
  
    }
    public void testGetName(){
    String myRank=getName(1888,451,"M");
    }
    public void testHighestRank(){
   int Rank=yearOfHighestRank("Genevieve" ,"F"); 
   System.out.println("year of highest ranking "+ Rank);
    
    }
     public void testAverage(){
   double Rank=getAverageRank("robert","M"); 
   System.out.println("avaerage ranking "+ Rank);
}
   public void  rankHigherThanFreqsz(){
    
    rankHigherThan(1234, "Emily", "F");
}
    }

