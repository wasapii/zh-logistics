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
			$.post("warehouseAction!delete.action",{id:id},function(){
				location.href = "warehouseAction!queryAll.action";
			});
		}
	});
	//仓库新增弹出窗
	/*$("#addWarehouse").click(function(){
		$.post("",function(){
			$.layer({
			    type: 2,
			    shadeClose: true,
			   	title: false,
				closeBtn: [0, true],
			    border: [0],
			    offset: ['20px',''],
			    area: ['800px', ($(window).height() - 50) +'px'],
			    iframe: {src: "jsp/warehouse/addWarehouse.jsp"}
			}); 
			
		});
	});*/
	//仓库修改
	$("#updateWarehouse").click(function(){
		var checkbox = $("input[name=checkbox]:checked");
		var checkNum = checkbox.val();
		var checkboxLength = checkbox.length;
		if(checkboxLength==0){
			alert("请先选择一条数据");
		}else if(checkboxLength>1){
			alert("请勿选择多条数据");
		}else{
			$.post("",function(){
				location.href = "warehouseAction!toUpdateWarehouse.action?warehouse.id="+checkNum;
				/*$.layer({
				    type: 2,
				    shadeClose: true,
				   	title: false,
					closeBtn: [0, true],
				    border: [0],
				    offset: ['20px',''],
				    area: ['800px', ($(window).height() - 50) +'px'],
				    iframe: {src: "warehouseAction!toUpdateWarehouse.action?warehouse.id="+checkNum}
				}); */
			}); 
		}
	});
	//删除
	
});
