package ${package.Controller};

import ResultCodeEnum;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ResponseModel;
import ${package.ServiceImpl}.${table.serviceImplName};
import ${package.Entity}.${table.entityName};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
/**
* <p>
    * ${table.comment!}控制器
    * </p>
*
* @author libar${author}
* @since ${date}
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
@Api(value="${table.comment!}接口",tags={"${table.comment!}"},description = "${table.comment!}增删改查相关接口")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName}{
    <#else>
public class ${table.controllerName} {
    </#if>

    @Autowired
    private ${table.serviceImplName} ${table.entityName?lower_case}Service;
    @ApiOperation(value = "列表查询")
    @PostMapping(value = "/query",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel query(@RequestBody QueryEntity<${table.entityName}> queryEntity){
        IPage<${table.entityName}> result = ${table.entityName?lower_case}Service.page(queryEntity.pages(),queryEntity.condition());
        return ResponseModel.success(result);
    }

    @ApiOperation(value = "获取详情")
    @PostMapping("/detail")
    public ResponseModel get(String id){
        ${table.entityName} result = ${table.entityName?lower_case}Service.getById(id);
        return result == null ? ResponseModel.error(ResponseModel.error(ResultCodeEnum.RECORD_NOTFOUND)) : ResponseModel.success(result);
    }

    @ApiOperation(value = "增加/修改")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseModel save(@RequestBody @Valid ${table.entityName} ${table.entityName?lower_case}, BindingResult result){
        if(result.hasErrors()){
            List<String> message = new ArrayList<>();
            for (ObjectError error : result.getAllErrors()) {
                message.add(error.getDefaultMessage());
            }
            return ResponseModel.error(100,String.join(",",message));
        }
        boolean state = ${table.entityName?lower_case}Service.saveOrUpdate(${table.entityName?lower_case});
        return state ? ResponseModel.success() : ResponseModel.error();
    }

    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    public ResponseModel delete(String[] ids){
        for (String id : ids){
            ${table.entityName?lower_case}Service.removeById(id);
        }
        return ResponseModel.success();
    }

    @ApiOperation(value = "搜索")
    @PostMapping("/search")
    public void search(){
    }
}
</#if>
