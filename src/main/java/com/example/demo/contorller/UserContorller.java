package com.example.demo.contorller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: 李林威
 * Date: 2019/7/3
 * Time: 14:47
 * To change this template use File / Settings / File Templates.
 * Description:
 */

@Controller
public class UserContorller {
    @Autowired
    private UserService userService;

    @GetMapping("all")
    public String all(Model model) {
        List<User> users = this.userService.selectUserByName();
        model.addAttribute("users", users);
        return "users";
    }
    @ResponseBody//返回json数据
    @RequestMapping(value = "/excelImport", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile file)throws IOException {
        if (file.isEmpty()) {
            return "文件为空";
        }
        //根据路径获取这个操作excel的实例
        Workbook wb = null;
        try {
            wb = new XSSFWorkbook(file.getInputStream());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //根据页面index 获取sheet页
        Sheet sheet = wb.getSheetAt(0);


        //循环sesheet页中数据从第一行开始，第一行是标题 rowNum==0是标题开始  rowNum==1是数据
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);//根据索引获取每一行
            /*  Object [] values = new Object[row.getLastCellNum()];*/
               /* for (int cellNum=1;cellNum< row.getLastCellNum(); cellNum ++){
                    //根据索引获取每一个单元格
                    Cell cell = row.getCell(cellNum);
                    //获取每一个单元格的内容
                    Object value = getCellValue(cell);
                    values[cellNum] = value;*/
            if (row == null) {
                continue;
            }
               /* for (int c = 0; c < rowNum; c++) {
                    Cell cell = row.getCell(c);
                    String value = "";
                    if (null != cell) {

                        // 以下是判断数据的类型
                        CellType type = cell.getCellTypeEnum();

                        switch (type) {
                            case NUMERIC: // 数字
                                value = cell.getNumericCellValue() + "";
                                break;
                            case STRING: // 字符串
                                value = cell.getStringCellValue();
                                break;
                            case BOOLEAN: // Boolean
                                value = cell.getBooleanCellValue() + "";
                                break;
                            case FORMULA: // 公式
                                try {
                                    value = cell.getStringCellValue();
                                } catch (IllegalStateException e) {
                                    value = String.valueOf(cell.getNumericCellValue());
                                }
                                break;
                       *//* cellValue = cell.getCellFormula() + "";
                        break;*//*
                            case BLANK: // 空值
                                value = "";
                                break;
                            case _NONE: // 故障
                                value = "非法字符";
                                break;
                            default:
                                value = "未知类型";
                                break;
                        }
                    }
                    return value;
                }*/
            //实体类集合
            List<User> list = new ArrayList<>();
            User user = new User();
            user.setId((String) getCellValue(row.getCell(0)));
            user.setName((String) getCellValue(row.getCell(1)));
            user.setAge((String) getCellValue(row.getCell(2)));
            user.setSex((String) getCellValue(row.getCell(3)));
            user.setClasses((String) getCellValue(row.getCell(4)));
            list.add(user);
            userService.saveAll(list);
        }
        /*User user = new User(value);*/

                /*list.add(user);

            }*/
        return "导入成功";


    }
/*    public static String getCellValue(Cell cell){
        //1.获取单元格的属性类型
        CellType cellType = cell.getCellType();
        //2.根据单元格数据类型获取数据
        Object value = null;
        switch (cellType){
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)){
                    //日期格式
                    value = cell.getDateCellValue();

                }else{
                    //数字
                    value = cell.getNumericCellValue();
                }
                break;
            case FORMULA://公式
                value = cell.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }*/

    /**
     * @Description: 根据id 删除
     * @Author: 李林威
     * @CreateDate: 2019/7/9 14:46
     * @Version: 1.0
     */

    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable String id) {
        userService.deleteById(id);
        ModelAndView mav = new ModelAndView("redirect:/all");
        return mav;
    }

    @RequestMapping("Add1")
    public ModelAndView Add1() {
        return new ModelAndView("add");
    }

    /**
     * @Description: 添加
     * @Author: 李林威
     * @CreateDate: 2019/7/9 17:05
     */
    @RequestMapping("AddUser")
    public ModelAndView AddUser(User user) {
        userService.add(user);
        ModelAndView mav = new ModelAndView("redirect:/all");
        return mav;
    }

    private class ImportData {
    }
}