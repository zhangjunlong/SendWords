/**
 * SI custom user interface JavaScript
 * 
 * 
 * @author Zhang Junlong
 * @requires JQuery
 * 
 * Copyright 2011, Smart Interactive Microsystems
 */

var si = si ? si : {};
si.ui = si.ui ? ui : {};

/**
 * Clear content
 */
si.ui.clear = function(obj) {
	if($(obj).attr('placeholder') != null) {
		if($(obj).val() == $(obj).attr('placeholder'))
			$(obj).val('');
	} else 
		$(obj).val('');
};

/**
 * Show a loading mask DIV
 */
si.ui.showLoading = function(targetId) {
	if(null == targetId)
		$('body').append('<div id="loading" class="lock"></div>');
	else {
		$('#'+targetId+'Loading').remove();
		$('#'+targetId).append('<div id="'+targetId+'Loading" class="loadCircle"></div>');
	}
};

/**
 * Close the loading mask DIV
 */
si.ui.closeLoading = function(targetId) {
	if (null == targetId)
		$("#loading").remove();
	else
		$('#' + targetId + 'Loading').remove();
};

/**
 * Focus on fist visible input box
 * 
 * @param formId optional
 */
si.ui.focusFirstInput = function(formId) {
	var form;

	if (null == formId)
		form = $('form:visible');
	else
		form = $('#' + formId);

	if (form.length > 0)
		form = form[0];

	$.each(form, function(index, element) {
		if (element.type != 'hidden' && element.disabled != 'disabled') {
			if (element.type == 'text' && element.value.length > 0) {
				element.blur();
				return false;
			} else {
				element.focus();
				return false;
			}
		}
	});
};

/**
 * Bind on mouse over event on list
 */
si.ui.setSelectListStyle = function() {

	$('.list li').live('mouseover', function() {
		$(this).addClass('selected');
	});

	$('.list li').live('mouseout', function() {
		$(this).removeClass('selected');
	});
};

/**
 * Creation of  common elements on interface
 */

/**
 * Create pagination info for records
 * 
 * @param callback A callback function that is called when a user clicks on a pagination link.
 * @param recordsCount Maximum number of pagination links that are visible.
 * @param pageNo The page that is selected when the pagination is initialized. Default: 1
 * @param pageSize The number of items per page.
 * @param target The target area where the content will display. Default area id is "pageBar"
 */
si.ui.createPagebar = function (callback,recordsCount,pageNo,pageSize,target) {
	recordsCount--;

	if(null==pageNo)
		pageNo=1;
	else
		pageNo--;
	
	if(null==pageSize)
		pageSize=globalOption.pageSize;
	
	if(null==target)
		target="#pageBar";
	
	$(target).pagination(recordsCount, {
        callback: showProduct,
        prev_text: '上一页',
        next_text: '下一页',
        items_per_page:pageSize,
        current_page:pageNo
	});
};

/**
 * UI data operations
 */
si.ui.dao = si.ui.dao ? dao : {};

si.ui.dao.create = function() {
	si.ui.showLoading();
	
	$('#daoForm').each( function(){this.reset();} );
	$('#_put_method').remove();
	$("#id").remove();
	$('#currentDaoOperation').html('新建');
	$('#del').hide();
	$('#operation').show();

	si.ui.focusFirstInput();
	si.ui.closeLoading();
};

si.ui.dao.update = function(option) {
	si.ui.showLoading();

	$.getJSON(option.url, function(data) {
		$('#_put_method').remove();
		$('#daoForm').append('<input id="_put_method" type="hidden" name="_method" value="put"/>');
		$("#id").remove();
		$('#daoForm').append('<input id ="id" type="hidden" name="id" />');
		$('#currentDaoOperation').html('更新');
		
		option.callback(data);
		
		$('#del').show();
		$('#operation').show();
		
		si.ui.focusFirstInput();
		si.ui.closeLoading();
	});
};

si.ui.dao.del = function(option) {
	if (!confirm('确认删除？')) {
		return;
	}

	si.ui.showLoading();

	$.post(option.url, 
		{_method : 'delete'}, 
		function(data) {
			showAll();
			$('#daoForm').each( function(){this.reset();} );
			si.ui.dao.cancel();
		}
	);

	si.ui.closeLoading();
};

si.ui.dao.cancel = function() {
	//$('#operation div').hide();
	$("#operation").hide();
};

/**
 * Validations
 */
si.ui.form = si.ui.form ? form : {};
si.ui.form.input = si.ui.form.input ? input : {};

si.ui.form.input.notNull = function(obj) {
	if (obj.length <= 0) {
		return false;
	} else {
		return true;
	}
};