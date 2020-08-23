package com.imooc.sell.controller;

import com.imooc.sell.VO.ProductInfoVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//返回是json格式，所以需要使用 @RestController 注解
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list01")
    public ResultVO list01(){

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        ProductVO productVO = new ProductVO();
        resultVO.setData(Arrays.asList(productVO));

        ProductInfoVO productInfoVO = new ProductInfoVO();
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

        return resultVO;

    }

    @GetMapping("list")
    public ResultVO list(){
        /**
         * 从数据库中查询出结果并展示要做如下3个步骤
         */
        //1. 查询所有的上架商品；属于数据库的查询，千万不要放到循环中去
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询需要的类目，不是所有的，且需要一次性查询，不是按商品数量进行循环
        /*List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        for(ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/

        //精简方法（使用Java8 特性 Lambda表达式）
        List<Integer> categoryTypeList = productInfoList.stream().
                map(e -> e.getCategoryType()).
                collect(Collectors.toList());
                //属于数据库的查询，千万不要放到循环中去
        List<ProductCategory> productCategoryList = categoryService.findBycategoryTypeIn(categoryTypeList);

        //3. 数据拼装，拼装成json格式那样的结果
        //数据库查询结果在代码中循环拼装；查询千万不要放到循环中去
        //按照接口文档中Json的格式，先遍历类目，再遍历商品详情
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //这里设置对象的属性值，可以采用像类目一样逐个set的方式；更优雅的方式是用copy属性的方式
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        /*ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productVOList);
        return resultVO;*/
        //每个controller如果都手动写这个resultVo的set和return的话，很浪费时间，进行封装下，提高效率
        return ResultVOUtil.success(productVOList);
    }
}
