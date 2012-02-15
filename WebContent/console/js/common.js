/**
 * Common setting and functions
 * 
 * @Author Zhang Junlong
 */

/**
 * Common JQuery form option
 */
var globalOption = {
	pageSize: 15	
};

var ajaxFormOptions = {
	dataType : 'JSON',
	beforeSerialize : function(form, options) {
		options.url = $(form).attr('action');
	},
	beforeSubmit : function() {
		si.ui.showLoading();
		return true;
	},
	success : function() {
		si.ui.closeLoading();
		showAll();
		si.ui.focusFirstInput();
		$('#cancel').click();
	},
	resetForm : true
};

/**
 * Convert normal form(s) to ajax-submit form(s)
 * 
 * Depends on jQuery.form
 * 
 * @param formId
 *            form ID String , optional
 */
function convertToAjaxForm(formId) {
	var forms = null;

	if (null == formId) {
		$.each($('form'), function(i, form) {
			$(form).submit(function() {
				$(this).ajaxSubmit(ajaxFormOptions);
				return false;
			});
		});
	} else {
		$('#' + formId).submit(function() {
			$(this).ajaxSubmit(ajaxFormOptions);
			return false;
		});
	}
}

/**
 * Bind validation on form
 */
function bindAjaxFormValidation(formId) {
	var forms = null;

	if (null == formId) {
		$.each($('form'), function(i, form) {
			$(form).validate({
				submitHandler : function(form) {
					$(form).ajaxSubmit(ajaxFormOptions);
					return false;
				}
			});
		});
	} else {
		$('#' + formId).validate({
			submitHandler : function(form) {
				$(form).ajaxSubmit(ajaxFormOptions);
				return false;
			}
		});
	}
}
