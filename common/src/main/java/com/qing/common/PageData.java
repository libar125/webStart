//package com.qing.common;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.github.pagehelper.Page;
//import lombok.Data;
//
//import java.io.Serializable;
//import java.util.List;
//
//@Data
//public class PageData implements Serializable {
//
//    private static final long serialVersionUID = -258640836642412544L;
//    @JsonIgnore
//    public static final Integer PAGE_SIZE=20;
//
//
//    /**
//     * 总条数
//     */
//    private Long total;
//    /**
//     * 总页数
//     */
//    private Integer totalPages;
//
//    /**
//     * 是否为最后一页
//     */
//    private Boolean lastPage=false;
//
//    /**
//     * 数据
//     */
//    private List pageData;
//
//    /**
//     *
//     * @param pageData 数据
//     * @param page 当前页
//     */
//    public PageData(Page pageData, Integer page){
//        if(pageData==null){
//            return;
//        }
//        this.pageData=pageData.getResult();
//        this.total=pageData.getTotal();
//        this.totalPages=pageData.getPages();
//        if(page.equals(totalPages)){
//            this.lastPage=true;
//        }
//    }
//    public PageData(List data){
//        this.total=1L;
//        this.totalPages=1;
//        this.pageData=data;
//        this.lastPage=true;
//    }
//    public PageData(List data,Long total,Integer totalPages,Integer page){
//        if(data==null){
//            return;
//        }
//        this.pageData=data;
//        this.total=total;
//        this.totalPages=totalPages;
//        if(page.equals(totalPages)){
//            this.lastPage=true;
//        }
//    }
//    public void setDataList(List data){
//        this.pageData=data;
//    }
//}
//
