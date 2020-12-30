/**
 * 영화진흥위원회 API - XML로 데이터를 받는 경우
 */
$(function(){
	init();
	
	$("#btn1").click(function(){
		let url ="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
		url += $("#txtYear").val()+$("#selMon").val()+$("selDay").val();
		
		let str="";
		
		$.get({
			url:url,
			success:function(data){
				console.log(data);
				
				$(data).find("dailyBoxOffice").each(function(){
					
					//순위
					result += $(this).find("rank").text()+"위";
					//증감
					var rankInten = parseInt($(this).find("rankInten").text());
					
					if(rankInten>0){
						str = str + "(▲";
					}else if(rankInten<0){
						str = str+"(▼";
					}else{
						str = str + "(";
					}
					str += rankInten + ")";
					
					//영화명
					var movieNm = $(data).find("movieNm").text();
					str += movieNm = $(data).find("movieNm").text();
					//영어제목
					var movieNmEn = $(data).find("movieNmEn").text();
					//상영시간
					var showTm = $(data).find("showTm").text();
					//감독
					var peopleNm = $(data).find("director").find("peopleNm").text();
					//출연배우
					var actors ="";
					
					var length = $(data).find("actor").find("peopleNm").length;
					$(data).find("actor").each(function(idx,item){
						if(idx == length-1){
						actors += $(this).find("peopleNm").text();
					} else{
						actors += $(this).find("peopleNm").text()+",";
					}
				
				})
				
				str += "<li>영화제목 : "+movieNm+"</li>"
				str += "<li>영어제목 : "+movieNmEn+"</li>"
				str += "<li>상영시간 : "+showTm+"</li>"
				str += "<li>감독 : "+peopleNm+"</li>"
				str += "<li>출연배우 : "+actors+"</li></ul>"
				
				$(".box3").hrml(str);
			}
		})
	})
})
	function init(){
		//어제 날짜 세팅
		var newDate = new Date();
		var year = newDate.getFullYear(); //년도
		var month = newDate.getMonth()+1; //월은 0부터 시작
		var day = newDate.getDay()-1; //어제날짜 추출때문에 -1
		
		$("#txtYear").val(year);
		
		if(month<10){
			month = "0"+month;
		}
		if(day<10) {
			day="0"+day;			
		}
		
		$("#selMon").val(month);
		$("#selDay").val(day);
	}