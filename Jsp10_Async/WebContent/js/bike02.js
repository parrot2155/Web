
$(function(){
	parseJson();
});

function parseJson(){
	$.getJSON("json/bike.json",function(data){
		$.ajax({
			url:"bike.do?command=second_db",
			method:"post",
			data:{"obj":JSON.stringify(data)},	//json타입을 string으로 변환한다.
			success:function(msg){
				//alert(msg);
				
				if(msg>0){
					$.each(data,function(key,val){
						if(key=="DESCRIPTION"){
							$("table").attr("border","1");
							
							$("thead").append(
								"<tr>"+
									"<th>"+val.ADDR_GU+"</th>"+
									"<th>"+val.CONTENT_ID+"</th>"+
									"<th>"+val.CONTENT_NM+"</th>"+
									"<th>"+val.NEW_ADDR+"</th>"+
									"<th>"+val.CRADLE_COUNT+"</th>"+
									"<th>"+val.LONGITUDE+"</th>"+
									"<th>"+val.LATITUDE+"</th>"+
								"</tr>"	 
							)
						}else{
							//key가 =='DATA'
							for(let i=0;i<val.length;i++){
								//str : 배열 안에 있는 하나의 json
								let str = val[i];
								$("tbody").append(
									"<tr>"+
										"<td>"+str.addr_gu+"</td>"+
										"<td>"+str.content_id+"</td>"+
										"<td>"+str.content_nm+"</td>"+
										"<td>"+str.new_addr+"</td>"+
										"<td>"+str.cradle_count+"</td>"+
										"<td>"+str.longitude+"</td>"+
										"<td>"+str.latitude+"</td>"+
									"</tr>"
								);
							}
						}
					});
				}
			},
			error:function(){
				alert("data 저장 실패///")
			}
		});
	});
}
















