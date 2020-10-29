(function($){
	var zp = {
		init:function(obj,pageinit){
			return (function(){
				zp.addhtml(obj,pageinit);
				if(pageinit.first_or_not == 1){
					zp.bindEvent(obj,pageinit);
				}else{
					zp.offEvent(obj,pageinit);
					zp.bindEvent(obj,pageinit);
				}
			}());
		},
		addhtml:function(obj,pageinit){
			return (function(){
				obj.empty();
				/*上一页*/
				if (pageinit.current > 1) {
					obj.append('<a href="javascript:;" class="prebtn">上一页</a>');
				} else{
					obj.remove('.prevPage');
					obj.append('<span class="disabled">上一页</span>');
				}
				/*中间页*/
				if (pageinit.current >4 && pageinit.pageNum > 4) {
					obj.append('<a href="javascript:;" class="zxfPagenum">'+1+'</a>');
					obj.append('<a href="javascript:;" class="zxfPagenum">'+2+'</a>');
					obj.append('<span>...</span>');
				}
				if (pageinit.current >4 && pageinit.current <= pageinit.pageNum-5) {
					var start  = pageinit.current - 2,end = pageinit.current + 2;
				}else if(pageinit.current >4 && pageinit.current > pageinit.pageNum-5){
					var start  = pageinit.pageNum - 4,end = pageinit.pageNum;
				}else{
					var start = 1,end = 9;
				}
				for (;start <= end;start++) {
					if (start <= pageinit.pageNum && start >=1) {
						if (start == pageinit.current) {
							obj.append('<span class="current">'+ start +'</span>');
						} else if(start == pageinit.current+1){
							obj.append('<a href="javascript:;" class="zxfPagenum nextpage">'+ start +'</a>');
						}else{
							obj.append('<a href="javascript:;" class="zxfPagenum">'+ start +'</a>');
						}
					}
				}
				if (end < pageinit.pageNum) {
					obj.append('<span>...</span>');
				}
				/*下一页*/
				if (pageinit.current >= pageinit.pageNum) {
					obj.remove('.nextbtn');
					obj.append('<span class="disabled">下一页</span>');
				} else{
					obj.append('<a href="javascript:;" class="nextbtn">下一页</a>');
				}
				/*尾部*/
				obj.append('<span>'+'共'+'<b>'+pageinit.pageNum+'</b>'+'页，'+'</span>');
				obj.append('<span>'+'到第'+'<input type="number" class="zxfinput" value=""/>'+'页'+'</span>');
				obj.append('<span class="zxfokbtn">'+'确定'+'</span>');
				pageChange(pageinit.current);
			}());
		},
		bindEvent:function(obj,pageinit){
			return (function(){
				obj.on("click","a.prebtn",function(){
					var cur = parseInt(obj.children("span.current").text());
					var current = $.extend(pageinit, {"current":cur-1});
					zp.addhtml(obj,current);
					if (typeof(pageinit.backfun)=="function") {
						pageinit.backfun(current);
					}
				});
				obj.on("click","a.zxfPagenum",function(){
					var cur = parseInt($(this).text());
					var current = $.extend(pageinit, {"current":cur});
					zp.addhtml(obj,current);
					if (typeof(pageinit.backfun)=="function") {
						pageinit.backfun(current);
					}
				});
				obj.on("click","a.nextbtn",function(){
					var cur = parseInt(obj.children("span.current").text());
					var current = $.extend(pageinit, {"current":cur+1});
					zp.addhtml(obj,current);
					if (typeof(pageinit.backfun)=="function") {
						pageinit.backfun(current);
					}
				});
				obj.on("click","span.zxfokbtn",function(){
					var cur = parseInt($("input.zxfinput").val());
					if(cur > 0 && cur <= pageinit.pageNum){
						var current = $.extend(pageinit, {"current":cur});
					    zp.addhtml(obj,{"current":cur,"pageNum":pageinit.pageNum});
				        if (typeof(pageinit.backfun)=="function") {
						    pageinit.backfun(current);
					    }
					}
				});
				obj.on("keyup","input.zxfinput",function(){
					var cur = parseInt($("input.zxfinput").val());
					if(cur <= 0 || cur > pageinit.pageNum){
						$(".zxfinput").val("");
					}
				});
			}());
		},
		offEvent:function(obj,pageinit){
			return (function(){
				obj.off("click","a.prebtn");
				obj.off("click","a.zxfPagenum");
				obj.off("click","a.nextbtn");
				obj.off("click","span.zxfokbtn");
				obj.off("keyup","input.zxfinput");
			}());
		}
	}
	$.fn.createPage = function(options){
		var pageinit = $.extend({
			pageNum : 15,
			current : 1,
			first_or_not : 1,
			backfun : function(){}
		},options);
		zp.init(this,pageinit);
	}
}(jQuery));

    	//计算页数
    	function calcutePageNum(result){
    		var result_num = Object.keys(result).length;
    		var page_num;
    		if(result_num % 10 != 0){
    			page_num = Math.floor(result_num / 10) + 1;
    		}else{
    			page_num = result_num / 10;
    		}
    		return page_num;
    	};
        //添加翻页,first_or_not为1表示第一次添加，需要监听，为0则表示不是第一次添加，已经有了监听，不需要再添加方法
    	function addPage(page_num,cur_num,first_or_not){
    		$(".zxf_pagediv").empty();
    		$(".zxf_pagediv").createPage({
			    pageNum: page_num,
			    current: cur_num,
			    first_or_not: first_or_not,
			    backfun: function(e) {
			    //console.log(e);//回调
			    }
		    });
    	};
