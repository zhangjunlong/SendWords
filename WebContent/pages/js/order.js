var order = {
	/**
	 * 当前产品id
	 */
	currentProductId:null,
	/**
	 * 当前搜索页号
	 */
	currentSearchPage:0,
	/**
	 * 当前页结果数量
	 */
	currentPageResultSize:1,
	/**
	 * 搜索关键字
	 */
	keyword:null,
	/**
	 * 获取搜索类型
	 */
	querySearchType:null,
	/**
	 * 已订未订
	 */
	orderType:0,
	/**
	 * 搜索产品的触发源
	 */
	source:null,
	/**
	 * 根据输入条件搜索产品
	 * @param keyword
	 * @param source 0：首页全部产品列表 1: 主界面快捷订购 2: 记事本 3：类型搜索
	 */
	searchProduct:function(keyword,source,currentPage,querySearchType){
        order.keyword = keyword?keyword:"";
        order.source = source;
        order.querySearchType = querySearchType;

        if(source==3){
            order.keyword = "";
            $('#productInfoContent').val("");
            order.orderType = $('#orderType').val();
        }

        order.seachProductByPage(currentPage);
	},
	/**
	 * 按分页搜索产品
	 */
	seachProductByPage:function(page){
	   $.ajax({
            type: "POST",
            url: "/woms/order/"+utils.userId+"/searchProductByKeyword.json?timestamp="+new Date().getTime(),
            cache:false,
            dataType: "json",
			data : {
				"model.size" : 5,
				"model.section" : page + 1,
				"model.notepadKeyword" : order.keyword,
				"model.orderType" : order.orderType,
				"model.querySearchType" : order.querySearchType,
				"model.productSeason" : $('#productSeason').val(),
				"model.productStyle" : $('#productStyle').val()
			},
            success: function(data){
            	order.keyword = "";
            	order.currentSearchPage = page;
            	order.currentPageResultSize = data.products.resultList.length;
            	if(order.querySearchType){
                    $.each(data.styles,function(i,style){
                        $('#productStyle').append('<option value="'+style.id+'">'+style.name+'</option>');
                    });
                    $.each(data.seasons,function(i,season){
                        $('#productSeason').append('<option value="'+season.id+'">'+season.name+'</option>');
                    });
            		order.querySearchType = null;
            	}
            	
                var firstProductStyleNo = null;
            	
                var html = '';
                $.each(data.products.resultList,function(i,product){
                	if(i==0){
                		firstProductStyleNo = product.model;
                	}
                    html += '<li class="product_item">'+
                       '<a href="#productDetailPage" onclick="javascript:order.selectProduct('+product.id+');" id="product_'+product.model+'" style="padding-top:0;padding-bottom:0;">'+
                       '<p>'+
                       '<span>款名：'+product.name+'<br/>款号：'+product.model+'<br/>类别：'+product.category+'</span>'+
                       '<span>助记码：'+product.brevityCode+'<br/>订货价：'+product.orderingPrice+'<br/>吊牌价：'+product.sellingPrice+'</span>'+
                       '<span>波段：'+product.season+'<br/>系列：'+product.series+'<br/>款型：'+product.style+'</span>'+
                       '</p>'+
                       '</a><span id="orderCount_'+product.id+'" class="ui-li-count">'+product.orderCount+'</span></li>';
                });
                $('#productList').html(html).listview('refresh');
                
                if(order.source==2)
                    $('.ui-dialog').dialog('close');

                if(order.source==1&&data.products.recordsCount==1){
                    $('#product_'+firstProductStyleNo).click();
                }

                $("#paginationDiv").pagination(data.products.recordsCount, {
                    callback: order.seachProductByPage,//回调函数
                    prev_text: '上一页',
                    num_display_entries: 5,
                    num_edge_entries: 3,
                    next_text: '下一页',
                    items_per_page:5,//每页显示多少条
                    current_page:page//当前页码
                });
            }
        });
	},
    /**
     * 选择产品列表中的某件产品
     */
    selectProduct:function(productId){
 		$.ajax({
        	type: "GET",
            url: "/woms/order/"+utils.userId+".json?timestamp="+new Date().getTime(),
            cache:false,
            dataType: "json",
            data: {"model.product.id":productId},
            success: function(data){
            	order.currentProductId = productId;
                order.constructProdutDetailInfoPage(data.product,data.orders);
            }
        });
    },
	/**
	 * 构造产品详细信息页面
	 * @param product
	 */
	constructProdutDetailInfoPage:function(product,orders){
		$('#productDetailInfo').html(
		  '<p style="display:inline-block;text-align:left;">'+
              '<span>款名：'+product.name+'<br/>款号：'+product.model+'<br/>类别：'+product.category.name+'</span>'+
              '<span>助记码：'+product.brevityCode+'<br/>订货价：'+product.orderingPrice+'<br/>吊牌价：'+product.sellingPrice+'</span>'+
              '<span>波段：'+product.season.name+'<br/>系列：'+product.series.name+'<br/>款型：'+product.style.name+'</span>'+
          '</p>'
		);
		
        $('#thead').html('<th></th>');
        $('#tbody').html('');
		
	    var sizeCache = '';
	    var sizeSort = new Array();
	    var colorSizeMap = new HashMap();
	    
	    //颜色排序
        var productColorSort = product.colorSizesCompositions;
        var t;
		for ( var i = 0; i < productColorSort.length - 1; i++) {
			for ( var j = 1; j < productColorSort.length; j++) {
				if (productColorSort[i].id > productColorSort[j].id) {
					t = productColorSort[i];
					productColorSort[i] = productColorSort[j];
					productColorSort[j] = t;
				}
			}
		}
		product.colorSizesCompositions = productColorSort;

		var sortedSizeMapMap = new HashMap();
		var sortedSizeIdMap = new HashMap();
	    $.each(product.colorSizesCompositions,function(i,colorSizesCompositions){
	        var sizeMap = new HashMap();
	        $.each(colorSizesCompositions.sizes,function(j,size){
	            if(sizeCache.indexOf("#"+size.id+"#")<0){
	                sizeCache += "#"+size.id+"#_";
	                sizeSort.push(size.sortId);
	                sortedSizeMapMap.put(size.sortId,size.name);
	                sortedSizeIdMap.put(size.sortId,size.id);
	            }
	            sizeMap.put(size.id, "");
	        });
		    colorSizeMap.put(colorSizesCompositions.color.id, sizeMap);
	    });
	    //尺码排序
	    sizeSort.sort(function compare(a,b){return a-b;});
        
	    $.each(sizeSort,function(j,sortId){
        	$('#thead').append('<th>'+sortedSizeMapMap.get(sortId)+'</th>');
        });

	    $.each(product.colorSizesCompositions,function(i,colorSizesCompositions){
	    	$('#tbody').append('<tr id="color_'+colorSizesCompositions.color.id+'"><td>'+colorSizesCompositions.color.name+'</td></tr>');
	    });

	    $.each(product.colorSizesCompositions,function(i,colorSizesCompositions){
	    	var html = '';
	    	$.each(sizeSort,function(j,sortId){
	    		var size = sortedSizeIdMap.get(sortId);
	    		if(colorSizeMap.get(colorSizesCompositions.color.id).containsKey(size)){
	            	html += '<td><input id="'+product.id+'_'+colorSizesCompositions.color.id+'_'+size+'" productId="'+product.id+'" ' +
	            			'colorId="'+colorSizesCompositions.color.id+'" sizeId="'+size+'" data-role="none" type="number" max="9999" min="0" step="0" maxlength="4" size="4"/></td>';
	    		}else{
	            	html+= '<td></td>';
	    		}
	    	});
            $('#color_'+colorSizesCompositions.color.id).append(html);
	    });
        $('#colorSizesCompositionsTable tr:even').addClass('even_tr');
        
        $.each(orders,function(i,productOrder){
            $('#'+product.id+'_'+productOrder.color.id+'_'+productOrder.size.id).val(productOrder.quantity);
        });
        
        if(orders.length>0){
            $('#deleteOrder').show();
        }else{
            $('#deleteOrder').hide();
        }
        
        $('#productPicture').attr('src','/woms/productPic/mini/'+product.model+'.jpg');
	},
	/**
	 * 往订货初选添加条件
	 */
    addNotepad:function(){
        $('#notepadContentTags').addTag($('#notePadContent').val());
        $('#notePadContent').val('');
    },
    /**
     * 订购产品
     */
    orderProduct:function(){
    	var totalCount = 0;
    	var orders = '{';
    	$.each($("#colorSizesCompositionsTable input[type='number'][value!='']"),function(i,orderInput){
    		if($(this).val()!=0){
        		orders += '"model.orders['+i+'].color.id":"'+$(this).attr('colorId')+'",';
        		orders += '"model.orders['+i+'].size.id":"'+$(this).attr('sizeId')+'",';
        		orders += '"model.orders['+i+'].quantity":"'+$(this).val()+'",';
        		orders += '"model.orders['+i+'].product.id":"'+$(this).attr('productId')+'",';
        		orders += '"model.orders['+i+'].account.id":"'+utils.userId+'",';
        		orders += '"model.orders['+i+'].account.userId":"'+utils.userName+'",';
        		
        		totalCount += parseInt($(this).val());
    		}
    	});
    	orders += '}';

    	if(totalCount>0){
     		$.ajax({
            	type: "POST",
                url: "/woms/order/1/create.json",
                cache:false,
                dataType: "json",
                data: eval('('+orders+')'),
                success: function(data){
                   $("#orderCount_"+order.currentProductId).html(totalCount);
                },
                error: function(){
                   $("#orderCount_"+order.currentProductId).html(totalCount);
                }
            });
    	}else{
    		alert("请输入您要订购该产品的数量！");
    	}
	 },
	 /**
	  * 删除订单
	  */
	 deleteOrder:function(source){
	 	if(confirm("您确定删除该订单吗？")){
            $.ajax({
                type: "POST",
                url: "/woms/order/"+utils.userId+"/destroy.json",
                data:{"model.product.id":order.currentProductId},
                dataType: "json",
                success: function(data){
                	if(source==2){
                        var page = 0;
                        if(order.currentPageResultSize==1){
                            page = order.currentSearchPage==0?0:order.currentSearchPage-1;
                        }else{
                           page = order.currentSearchPage;
                        }
                        order.seachProductByPage(page);
                	}
                   $("#orderCount_"+order.currentProductId).html(0);
                },
                error:function(){
                    if(source==2){
                        var page = 0;
                        if(order.currentPageResultSize==1){
                            page = order.currentSearchPage==0?0:order.currentSearchPage-1;
                        }else{
                           page = order.currentSearchPage;
                        }
                        order.seachProductByPage(page);
                    }
                   $("#orderCount_"+order.currentProductId).html(0);
                }
            });
            $('#backBtn').click();
	 	}
	 },
	 /**
	  * 订货任务
	  */
	 orderTask:function(){
	 	$.ajax({
            type: "POST",
            url: "/woms/account/"+utils.userId+"/accountTask.json?timestamp="+new Date().getTime(),
            dataType: "json",
            success: function(data){
            	var detailInfo = data.statisticsTask[0];
            	$('#orderTaskContent').html('');
            	if(data.targetAmount!=undefined&&data.targetAmount!=null&&data.targetAmount!=''&&data.targetAmount!=0){
                	$('#orderTaskContent').append('<tr><td>我的任务</td><td>'+data.targetAmount+'元</td></tr>');
            	}
            	$('#orderTaskContent').append('<tr><td>总件数</td><td>'+(detailInfo[1]==null?"0":detailInfo[1])+'件</td></tr>');
            	$('#orderTaskContent').append('<tr><td>总款数</td><td>'+(detailInfo[0]==null?"0":detailInfo[0])+'款</td></tr>');
            	$('#orderTaskContent').append('<tr><td>总金额</td><td>'+(detailInfo[2]==null?"0":detailInfo[2])+'元</td></tr>');
            	if(data.targetAmount!=undefined&&data.targetAmount!=null&&data.targetAmount!=''&&data.targetAmount!=0){
	            	$('#orderTaskContent').append('<tr><td>完成率</td><td>'+utils.round(detailInfo[2]/data.targetAmount*100,2)+'%</td></tr>');
	            	
	            	var distance = utils.targetCompute(detailInfo[2], data.targetAmount, 2);
	            	if(distance<0)
	            		$('#orderTaskContent').append('<tr><td>超出目标</td><td style="background-color: green;color: black">'+-distance+'</td></tr>');
	            	else
	            		$('#orderTaskContent').append('<tr><td>距离目标</td><td style="background-color: red;color: black">'+distance+'</td></tr>');
	            
	            	}
            }
        });
	 }
};