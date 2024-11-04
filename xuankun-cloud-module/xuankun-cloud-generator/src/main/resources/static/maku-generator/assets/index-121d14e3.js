import{d as w,r as T,a as x,b as r,o as U,c as h,w as l,e,f,A as z,E as D,z as N,v as m,B as R}from"./index-8dd9830b.js";import{u as H}from"./index-187cc916.js";import{a as S,b as B}from"./fieldType-14f831bb.js";const O=w({__name:"add-or-update",emits:["refreshDataList"],setup($,{expose:n,emit:y}){const v=y,p=T(!1),_=T(),o=x({id:"",columnType:"",attrType:"",packageName:"",createDate:""}),V=d=>{p.value=!0,o.id="",_.value&&_.value.resetFields(),d&&b(d)},b=d=>{S(d).then(t=>{Object.assign(o,t.data)})},C=T({columnType:[{required:!0,message:"必填项不能为空",trigger:"blur"}],attrType:[{required:!0,message:"必填项不能为空",trigger:"blur"}]}),a=()=>{_.value.validate(d=>{if(!d)return!1;B(o).then(()=>{D.success({message:"操作成功",duration:500,onClose:()=>{p.value=!1,v("refreshDataList")}})})})};return n({init:V}),(d,t)=>{const s=r("el-input"),g=r("el-form-item"),c=r("el-form"),k=r("el-button"),F=r("el-dialog");return U(),h(F,{modelValue:p.value,"onUpdate:modelValue":t[6]||(t[6]=u=>p.value=u),title:o.id?"修改":"新增","close-on-click-modal":!1},{footer:l(()=>[e(k,{onClick:t[4]||(t[4]=u=>p.value=!1)},{default:l(()=>[f("取消")]),_:1}),e(k,{type:"primary",onClick:t[5]||(t[5]=u=>a())},{default:l(()=>[f("确定")]),_:1})]),default:l(()=>[e(c,{ref_key:"dataFormRef",ref:_,model:o,rules:C.value,"label-width":"120px",onKeyup:t[3]||(t[3]=z(u=>a(),["enter"]))},{default:l(()=>[e(g,{label:"字段类型",prop:"columnType"},{default:l(()=>[e(s,{modelValue:o.columnType,"onUpdate:modelValue":t[0]||(t[0]=u=>o.columnType=u),placeholder:"字段类型"},null,8,["modelValue"])]),_:1}),e(g,{label:"属性类型",prop:"attrType"},{default:l(()=>[e(s,{modelValue:o.attrType,"onUpdate:modelValue":t[1]||(t[1]=u=>o.attrType=u),placeholder:"属性类型"},null,8,["modelValue"])]),_:1}),e(g,{label:"属性包名",prop:"packageName"},{default:l(()=>[e(s,{modelValue:o.packageName,"onUpdate:modelValue":t[2]||(t[2]=u=>o.packageName=u),placeholder:"属性包名"},null,8,["modelValue"])]),_:1})]),_:1},8,["model","rules"])]),_:1},8,["modelValue","title"])}}}),E=w({__name:"index",setup($){const n=x({dataListUrl:"/gen/fieldtype/page",deleteUrl:"/gen/fieldtype",queryForm:{columnType:"",attrType:"",packageName:""}}),y=T(),v=C=>{y.value.init(C)},{getDataList:p,selectionChangeHandle:_,sizeChangeHandle:o,currentChangeHandle:V,deleteBatchHandle:b}=H(n);return(C,a)=>{const d=r("el-input"),t=r("el-form-item"),s=r("el-button"),g=r("el-form"),c=r("el-table-column"),k=r("el-table"),F=r("el-pagination"),u=r("el-card"),L=N("loading");return U(),h(u,null,{default:l(()=>[e(g,{inline:!0,model:n.queryForm,onKeyup:a[5]||(a[5]=z(i=>m(p)(),["enter"]))},{default:l(()=>[e(t,null,{default:l(()=>[e(t,null,{default:l(()=>[e(d,{modelValue:n.queryForm.columnType,"onUpdate:modelValue":a[0]||(a[0]=i=>n.queryForm.columnType=i),placeholder:"字段类型"},null,8,["modelValue"])]),_:1}),e(t,null,{default:l(()=>[e(d,{modelValue:n.queryForm.attrType,"onUpdate:modelValue":a[1]||(a[1]=i=>n.queryForm.attrType=i),placeholder:"属性类型"},null,8,["modelValue"])]),_:1})]),_:1}),e(t,null,{default:l(()=>[e(s,{onClick:a[2]||(a[2]=i=>m(p)())},{default:l(()=>[f("查询")]),_:1})]),_:1}),e(t,null,{default:l(()=>[e(s,{type:"primary",onClick:a[3]||(a[3]=i=>v())},{default:l(()=>[f("新增")]),_:1})]),_:1}),e(t,null,{default:l(()=>[e(s,{type:"danger",onClick:a[4]||(a[4]=i=>m(b)())},{default:l(()=>[f("删除")]),_:1})]),_:1})]),_:1},8,["model"]),R((U(),h(k,{data:n.dataList,border:"",style:{width:"100%"},onSelectionChange:m(_)},{default:l(()=>[e(c,{type:"selection","header-align":"center",align:"center",width:"50"}),e(c,{prop:"columnType",label:"字段类型","header-align":"center",align:"center"}),e(c,{prop:"attrType",label:"属性类型","header-align":"center",align:"center"}),e(c,{prop:"packageName",label:"属性包名","header-align":"center",align:"center"}),e(c,{label:"操作",fixed:"right","header-align":"center",align:"center",width:"150"},{default:l(i=>[e(s,{type:"primary",link:"",onClick:q=>v(i.row.id)},{default:l(()=>[f("编辑")]),_:2},1032,["onClick"]),e(s,{type:"primary",link:"",onClick:q=>m(b)(i.row.id)},{default:l(()=>[f("删除")]),_:2},1032,["onClick"])]),_:1})]),_:1},8,["data","onSelectionChange"])),[[L,n.dataListLoading]]),e(F,{"current-page":n.page,"page-sizes":n.pageSizes,"page-size":n.limit,total:n.total,layout:"total, sizes, prev, pager, next, jumper",onSizeChange:m(o),onCurrentChange:m(V)},null,8,["current-page","page-sizes","page-size","total","onSizeChange","onCurrentChange"]),e(O,{ref_key:"addOrUpdateRef",ref:y,onRefreshDataList:m(p)},null,8,["onRefreshDataList"])]),_:1})}}});export{E as default};
