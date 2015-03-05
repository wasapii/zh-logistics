$(document).ready(function(){
	//下拉列表框
	$("#option").click(function(){
		var id = $("#select").val();
				$.ajax({
					url : "goodsJson!getCata.action",
					type : "post",
					data : id,
					dataType : "json",
					success : function(data) {
						var i = $("#select option").length;
						var category = eval("(" + data + ")");
						if(category.length > i){//若list的长度大于option的长度则说明option尚未添加则为首次触发，否则为二次触发
							$.each(category,function(idx,obj){
								 $("#select").append("<option value="+ obj.categoryCode +">" + obj.categoryName + "</option>");
							});
						}
						}, 
					error : function() {
						alert("error");
					}
				});
	});
	//删除
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
			$.post("goodsAction!deleteGoods.action",{id:id},function(){
				location.href = "goodsAction!queryAll.action";
			});
		}
	});
	//仓库修改
	$("#updateGoods").click(function(){
		var checkbox = $("input[name=checkbox]:checked");
		var checkNum = checkbox.val();
		var checkboxLength = checkbox.length;
		if(checkboxLength==0){
			alert("请先选择一条数据");
		}else if(checkboxLength>1){
			alert("请勿选择多条数据");
		}else{
			$.post("",function(){
				location.href = "goodsAction!toUpdate.action?goods.id="+checkNum;
			}); 
		}
	});
	
});
