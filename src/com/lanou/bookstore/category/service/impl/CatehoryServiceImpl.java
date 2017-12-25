package com.lanou.bookstore.category.service.impl;

import com.lanou.bookstore.category.dao.CateDao;
import com.lanou.bookstore.category.dao.impl.CategoryDaoImpl;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.CategoryException;
import com.lanou.bookstore.category.service.CategoryService;

import java.util.List;

/**
 * Created by dllo on 17/9/25.
 */
public class CatehoryServiceImpl implements CategoryService {

    private CateDao catedao = new CategoryDaoImpl();
    // 管理员登录
    @Override
    public boolean adminLogin(String adminname, String password) {
        boolean a = catedao.adminLogin(adminname,password);
        if (a){
            return a;
        }else {
            return false;
        }
    }
    // 查看所有分类
    @Override
    public List<Category> findAll() {
        return catedao.findAll();
    }

    // 添加分类
    @Override
    public void add(Category category) {
        catedao.add(category);
    }

    // 删除分类
    @Override
    public void delete(String cid) throws CategoryException{
        int count = catedao.getCount(cid);
        System.out.println(cid);
        System.out.println(count);
        if (count > 0){
            throw new CategoryException("该分类下有图书不能删除!");
        }else{

            catedao.delete(cid);
        }
    }

    @Override
    public Category editPre(String cid) {
      return  catedao.editPre(cid);

    }

    // 修改分类
    @Override
    public void updatePre(Category category) {
        catedao.update(category);
    }




}
