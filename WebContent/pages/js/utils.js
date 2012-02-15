var utils = {
	ajaxCache : false,

	userId : null,
	
	userName : null,

	getParameter : function(paramName) {
		var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	},

	round : function(number,bit) {
		return Math.round (number*Math.pow(10,bit))/Math.pow(10,bit); 
	},
	
	targetCompute : function (actual,target,bit) {
		return distance = this.round(target - actual,bit);
	}
};