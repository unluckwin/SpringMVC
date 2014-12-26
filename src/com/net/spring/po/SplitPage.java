package com.net.spring.po;
public class SplitPage {

    final public static String FIRSTPAGE="first";
    final public static String PREVIOUSEPAGE="previous";
    final public static String NEXTPAGE="next";
    final public static String LASTPAGE="last";
    
    private int pageRows=3;
    private int totalRows=0;
    private int currentPage=1;
    private int firstPage=1;
    private int totalPages=1;
    
    
    public int getCurrentPage() { 
           return currentPage; 
    } 
    public void setCurrentPage(int currentPage) { 
           this.currentPage = currentPage; 
    } 
    
    public int getFirstPage() { 
           return firstPage; 
    } 
    public void setFirstPage(int firstPage) { 
           this.firstPage = firstPage; 
    } 
    
    public int getPageRows() { 
           return pageRows; 
    } 
    public void setPageRows(int pageRows) { 
           if(pageRows==0)throw new ArithmeticException(); 
           this.pageRows = pageRows;
           this.totalPages=(this.totalRows%this.pageRows==0)?this.totalRows/this.pageRows:this.totalRows/this.pageRows+1; 
    }     
    public int getTotalRows() { 
           return totalRows; 
    }     
    
    public void setTotalRows(int totalRows) { 
           this.totalRows = totalRows; 
   
           this.totalPages=(this.totalRows%this.pageRows==0)?this.totalRows/this.pageRows:this.totalRows/this.pageRows+1; 
    } 
   
    public int getTotalPages() { 
           return totalPages; 
    } 
    
  
    
    
    public int confirmPage(String flag){ 
           int newPage=this.currentPage; 
           if(flag!=null){

                  if(flag.equals(SplitPage.FIRSTPAGE)){ 
                         newPage=1; 
                  }else if(flag.equals(SplitPage.LASTPAGE)){ 
                         newPage=this.totalPages; 
                  }else if(flag.equals(SplitPage.NEXTPAGE)){

                         newPage=(this.totalPages==this.currentPage)?this.currentPage:this.currentPage+1; 
                  }else if(flag.equals(SplitPage.PREVIOUSEPAGE)){ 

                         newPage=(this.firstPage==this.currentPage)?this.currentPage:this.currentPage-1; 
                  }else{

                         int tpage=Integer.parseInt(flag.trim()); 
                         newPage=tpage; 
                  } 
           }else{

                  newPage=this.currentPage; 
           } 

           this.setCurrentPage(newPage); 
           return newPage; 
    } 
}
