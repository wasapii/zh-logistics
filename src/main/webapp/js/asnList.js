function showDetail(note){
	var id = note.id;
	$.post("asnJson!queryDetail.action",{id:id},function(data){
		var invoiceDetails = eval("(" + data + ")");
			var trs = $("#tableDetail").find("tr");
			for(var i = 0;i<=trs.length-1;i++ ){
				if(i == 0){
					continue;
				}
				document.all["tableDetail"].deleteRow(1);  //删除第一行，注：循环时删除第一行之后第二行自动变为第一行（第0行为th）
			}
			$.each(invoiceDetails,function(idx,obj){
				var id =idx+1;

			$("#tableDetail").append("<tr>"
										+ "<td>" + id + "</td>" 
										+ "<td>" + obj.goodsCode + "</td>"
										+ "<td>" + obj.goodsName + "</td>"
										+ "<td>" + obj.goodsNum + "</td>"
										+ "<td>" + obj.goodsUnit + "</td>"
										+ "<td>" + obj.goodsUnitPrice + "</td>"
										+ "<td>" + obj.goodsSumPrice + "</td>"
										+ "<td>" + obj.memo + "</td>"
										+ "</tr>"); 
			});
		}, "json");
	}
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
			$.post("asnAction!deleteAsn.action",{id:id},function(){
				location.href = "asnAction!queryAll.action";
			});
		}
	});
	//修改
	$("#updateAsn").click(function(){
		var checkbox = $("input[name=checkbox]:checked");
		var checkNum = checkbox.val();
		var checkboxLength = checkbox.length;
		if(checkboxLength==0){
			alert("请先选择一条数据");
		}else if(checkboxLength>1){
			alert("请勿选择多条数据");
		}else{
			$.post("",function(){
				location.href = "asnAction!toUpdate.action?invoice.id="+checkNum;
			}); 
		}
	});
});
