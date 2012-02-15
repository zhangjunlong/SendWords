var report = {
	colorReport:function(){
        $('#chart1').html('');
        $('#chart2').html('');
		$.jqplot.config.enablePlugins = true;
        $.getJSON('/woms/color-report/' + utils.userName
                + '.json?timestamp='+new Date().getTime(), function(data) {
            items = data.colorReportItems;

            var quantityLine = [];
            var amountLine = [];
            $.each(items, function(index, i) {
                var quanItem = [];
                var amtItem = [];
                quanItem.push(i.colorCode + '-' + i.colorName + ' '
                        + i.quantity +'件');
                quanItem.push(i.quantity);
                quantityLine.push(quanItem);

                amtItem.push(i.colorCode + '-' + i.colorName + ' '
                        + i.amount +'元');
                amtItem.push(i.amount);
                amountLine.push(amtItem);
            });

            var plot1 = $.jqplot('chart1', [ quantityLine ], {
                title : '颜色订购数量占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });

            var plot2 = $.jqplot('chart2', [ amountLine ], {
                title : '颜色订购金额占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });
        });

	},
	seasonReport:function(){
        $('#chart1').html('');
        $('#chart2').html('');
		$.jqplot.config.enablePlugins = true;
        $.getJSON('/woms/season-report/' + utils.userName
                + '.json?timestamp='+new Date().getTime(), function(data) {
            items = data.seasonReportItems;

            var quantityLine = [];
            var amountLine = [];
            $.each(items, function(index, i) {
                var quanItem = [];
                var amtItem = [];
                quanItem.push(i.season + ' ' + i.quantity +'件');
                quanItem.push(i.quantity);
                quantityLine.push(quanItem);

                amtItem.push(i.season + ' ' + i.amount +'元');
                amtItem.push(i.amount);
                amountLine.push(amtItem);
            });

            var plot1 = $.jqplot('chart1', [ quantityLine ], {
                title : '波段订购数量占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });

            var plot2 = $.jqplot('chart2', [ amountLine ], {
                title : '波段订购金额占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });
        });
    },
	styleReport:function(){
        $('#chart1').html('');
        $('#chart2').html('');
		$.jqplot.config.enablePlugins = true;
        $.getJSON('/woms/style-report/' + utils.userName
                + '.json?timestamp='+new Date().getTime(), function(data) {
            items = data.styleReportItems;

            var quantityLine = [];
            var amountLine = [];
            $.each(items, function(index, i) {
                var quanItem = [];
                var amtItem = [];
                quanItem.push(i.styleName + ' ' + i.quantity +'件');
                quanItem.push(i.quantity);
                quantityLine.push(quanItem);

                amtItem.push(i.styleName + ' ' + i.amount +'元');
                amtItem.push(i.amount);
                amountLine.push(amtItem);
            });

            var plot1 = $.jqplot('chart1', [ quantityLine ], {
                title : '款型订购数量占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });

            var plot2 = $.jqplot('chart2', [ amountLine ], {
                title : '款型订购金额占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });
        });
    },
	categoryReport:function(){
        $('#chart1').html('');
        $('#chart2').html('');
		$.jqplot.config.enablePlugins = true;
        $.getJSON('/woms/category-report/' + utils.userName
                + '.json?timestamp='+new Date().getTime(), function(data) {
            items = data.categoryReportItems;

            var quantityLine = [];
            var amountLine = [];
            $.each(items, function(index, i) {
                var quanItem = [];
                var amtItem = [];
                quanItem.push(i.categoryName + ' ' + i.quantity +'件');
                quanItem.push(i.quantity);
                quantityLine.push(quanItem);

                amtItem.push(i.categoryName + ' ' + i.amount +'元');
                amtItem.push(i.amount);
                amountLine.push(amtItem);
            });

            var plot1 = $.jqplot('chart1', [ quantityLine ], {
                title : '大类订购数量占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });

            var plot2 = $.jqplot('chart2', [ amountLine ], {
                title : '大类订购金额占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });
        });
    },
	seriesReport:function(){
        $('#chart1').html('');
        $('#chart2').html(''); 
		$.jqplot.config.enablePlugins = true;
        $.getJSON('/woms/series-report/' + utils.userName + '.json?timestamp='+new Date().getTime(), function(data) {
            items = data.seriesReportItems;

            var quantityLine = [];
            var amountLine = [];
            $.each(items, function(index, i) {
                var quanItem = [];
                var amtItem = [];
                quanItem.push(i.seriesName + ' ' + i.quantity +'件');
                quanItem.push(i.quantity);
                quantityLine.push(quanItem);

                amtItem.push(i.seriesName + ' ' + i.amount +'元');
                amtItem.push(i.amount);
                amountLine.push(amtItem);
            });

            var plot1 = $.jqplot('chart1', [ quantityLine ], {
                title : '系列订购数量占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });

            var plot2 = $.jqplot('chart2', [ amountLine ], {
                title : '系列订购金额占比',
                seriesDefaults : {
                    renderer : $.jqplot.PieRenderer,
                    rendererOptions : {
                        sliceMargin : 8
                    }
                },
                legend : {
                    show : true
                }
            });
        });
    }
};