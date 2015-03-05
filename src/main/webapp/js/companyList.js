$(document).ready(function(){
	$("#delete").click(function() {
		var id = "";
		var length = 0;
		$("input[type='checkbox']:checked").each(function() {
			id += $(this).val() + " ";
			length++;
		});
		if (length == 0) {
			alert("请选择一条记录");
		} else {
			$.post("companyAction!deleteCompany.action",{id:id},function(){
				location.href = "companyAction!queryAll.action";
			});
		}
	});
	//仓库修改
	$("#updateCompany").click(function(){
		var checkbox = $("input[name=checkbox]:checked");
		var checkNum = checkbox.val();
		var checkboxLength = checkbox.length;
		if(checkboxLength==0){
			alert("请先选择一条数据");
		}else if(checkboxLength>1){
			alert("请勿选择多条数据");
		}else{
			$.post("",function(){
				location.href = "companyAction!toUpdate.action?company.id="+checkNum;
			}); 
		}
	});
});
