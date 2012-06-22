/**
 * SI Utilities
 * 
 * @author Zhang Junlong
 * @requires JQuery
 * 
 * Copyright 2012, Smart Interactive Microsystems
 */
var si = si ? si : {};
si.utils = si.utils ? si.utils : {};
si.utils.object = si.utils.object ? si.utils.object : new ObjectUtil();
si.support = si.support ? si.support : new BrowserDetector();
si.offline = si.offline ? si.offline : new OfflineHelper();

/**
 * Browser Detector
 * 
 * @returns
 */
function BrowserDetector() {
	this.userAgent = navigator.userAgent;
	this._osName = 'Unknow';
}
/**
 * Is current a mobile browser
 * 
 * @returns {Boolean}
 */
BrowserDetector.prototype.isMobile = function() {
	var mobile = false;
	var uaString = navigator.userAgent.toLowerCase();
	if (uaString.match(/ipad/i) == "ipad") {
		this._osName = 'iOS for iPad';
		this.mobile = true;
	} else if (uaString.match(/iphone/i) == "iphone") {
		this._osName = 'iOS for iPhone';
		this.mobile = true;
	} else if (uaString.match(/android/i) == "android") {
		this._osName = 'Android';
		this.mobile = true;
	} else if (uaString.match(/windows mobile/i) == "windows mobile") {
		this._osName = 'Windows Mobile';
		this.mobile = true;
	} else if (uaString.match(/windows ce/i) == "windows ce") {
		this._osName = 'Windows CE';
		this.mobile = true;
	} else if (uaString.match(/midp/i) == "midp") {
		this._osName = 'MIDP';
		this.mobile = true;
	} else if (uaString.match(/rv:1.2.3.4/i) == "rv:1.2.3.4") {
		this._osName = 'UCWeb7';
		this.mobile = true;
	} else if (uaString.match(/ucweb/i) == "ucweb") {
		this._osName = 'UCWeb';
		this._mobile = true;
	} else if (uaString.match(/mac os/i) == 'mac os') {
		this._osName = 'Mac OS';
	} else if (uaString.match(/windows nt/i) == 'Windows') {
		this._osName = 'Windows';
	}

	return mobile;
};
/**
 * Get short name of OS
 * 
 * @returns {String}
 */
BrowserDetector.prototype.getOSName = function() {
	this.isMobile();

	return this._osName;
};

BrowserDetector.prototype.detectCapabilities = function(showMsg) {
	// $("userAgent").innerHTML = navigator.userAgent;
	var hasWebWorkers = this.hasWebWorks = !!window.Worker;

	var hasGeolocation = this.hasGeoLocation = !!navigator.geolocation;

	var hasDb = this.hasWebSQLDb = !!window.openDatabase;

	var videoElement = document.createElement("video");
	var hasVideo = this.hasVideo = !!videoElement["canPlayType"];
	var ogg = false;
	var h264 = false;
	if (hasVideo) {
		ogg = videoElement.canPlayType('video/ogg; codecs="theora, vorbis"')
				|| "no";
		h264 = videoElement
				.canPlayType('video/mp4; codecs="avc1.42E01E, mp4a.40.2"')
				|| "no";
	}

	if (null != showMsg) {
		$('#' + showMsg).append('<br/>');
		$('#' + showMsg).append('- WebWorkers/多线程:' + hasWebWorkers + '<br/>');

		$('#' + showMsg).append(
				'- GeoLocation/地理位置:' + hasGeolocation
						+ '<br/><cite id="tmpLocal"></cite><br/>');
		if (hasGeolocation) {
			navigator.geolocation.getCurrentPosition(function(location) {
				$('#tmpLocal').append('(');
				$('#tmpLocal').append(location.coords.latitude);
				$('#tmpLocal').append(' ');
				$('#tmpLocal').append(location.coords.longitude);
				$('#tmpLocal').append(')');
			});
		}

		$('#' + showMsg).append('- Web SQL Database/网页数据库:' + hasDb + '<br/>');

		$('#' + showMsg).append('- Video/视频播放:' + hasVideo);
		$('#' + showMsg).append('(');
		$('#' + showMsg).append(' H.264:' + h264);
		$('#' + showMsg).append(' OGG:' + ogg);
		$('#' + showMsg).append(')');
	}
};

function OfflineHelper() {
	this._online = navigator.onLine;
}
OfflineHelper.prototype.isOnline = function() {
	return this._online;
};
/**
 * Refresh cached files
 * 
 * @param callback
 * @returns {Boolean}
 */
OfflineHelper.prototype.refreshCache = function(callback) {
	var refreshed = false;
	var msg = '无更新';
	var appCache = window.applicationCache;

	try {
		appCache.update();
	} catch (e) {
		msg = '更新出错';
	}

	if (appCache.status == window.applicationCache.UPDATEREADY) {
		appCache.swapCache();
		msg = '成功更新';
		refreshed = true;
	}

	if (callback) {
		callback(refreshed, msg);
	}

	return refreshed;
};
/**
 * Add an event to window.applicationCache.
 * 
 * Supported events:onchecking, onerror, onnoupdate, ondownloading, onprogress,
 * onupdateready, oncached and onobsolete.
 * 
 * @param event
 * @param handleCallback
 */
OfflineHelper.prototype.addCacheListener = function(event, handleCallback) {
	var appCache = window.applicationCache;
	appCache.addEventListener(event, handleCallback, false);
};
OfflineHelper.prototype.addStatusListener = function(callback) {
	document.body.addEventListener("online", function() {
		applicationCache.update();
		applicationCache.addEventListener("updateready", function() {
			applicationCache.swapCache();

		}, false);

		if (callback) {
			callback(navigator.onLine);
		}
	}, false);
	document.body.addEventListener("offline", function() {
		$("#olStatus").css('block si-ui sprite-cloud');

		if (callback) {
			callback(navigator.onLine);
		}
	}, false);
};

/**
 * A signed User cache
 */
si.utils.user = si.utils.user ? si.utils.user : {
	id : null,
	uname : null,
	name : null,
};

si.utils.url = si.utils.url ? si.utils.url : {
	ajaxCache : false,

	getParameter : function(paramName) {
		var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	},

	round : function(number, bit) {
		return Math.round(number * Math.pow(10, bit)) / Math.pow(10, bit);
	},

	targetCompute : function(actual, target, bit) {
		return distance = this.round(target - actual, bit);
	}
};

/**
 * HashMap
 * 
 * @returns
 */
function HashMap() {
	/** Map 大小 * */
	var size = 0;
	/** 对象 * */
	var entry = new Object();

	/** 存 * */
	this.put = function(key, value) {
		if (!this.containsKey(key)) {
			size++;
		}
		entry[key] = value;
	};

	/** 取 * */
	this.get = function(key) {
		return this.containsKey(key) ? entry[key] : null;
	};

	/** 删除 * */
	this.remove = function(key) {
		if (this.containsKey(key) && (delete entry[key])) {
			size--;
		}
	};

	/** 是否包含 Key * */
	this.containsKey = function(key) {
		return (key in entry);
	};

	/** 是否包含 Value * */
	this.containsValue = function(value) {
		for ( var prop in entry) {
			if (entry[prop] == value) {
				return true;
			}
		}
		return false;
	};

	/** 所有 Value * */
	this.values = function() {
		var values = new Array();
		for ( var prop in entry) {
			values.push(entry[prop]);
		}
		return values;
	};

	/** 所有 Key * */
	this.keys = function() {
		var keys = new Array();
		for ( var prop in entry) {
			keys.push(prop);
		}
		return keys;
	};

	/** Map Size * */
	this.size = function() {
		return size;
	};

	/** 清空 * */
	this.clear = function() {
		size = 0;
		entry = new Object();
	};
}

function ObjectUtil() {

}
/**
 * Traverse all properties of specified object, and display them by using
 * alert()
 * 
 * @param object
 */
ObjectUtil.prototype.traverse = function(object) {
	for ( var key in object) {
		var value = object[key];
		if ((typeof object[key]) == "function") {
			object[key]('Traverse Test.');
		} else {
			if (typeof object[key] == "object") {
				this.traverse(object[key]);
			} else {
				alert(key + ': ' + value);
			}
		}
	}
};