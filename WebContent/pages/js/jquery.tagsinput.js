/*

	jQuery Tags Input Plugin 1.2
	
	Copyright (c) 2010 XOXCO, Inc
	
	Documentation for this plugin lives here:
	http://xoxco.com/clickable/jquery-tags-input
	
	Licensed under the MIT license:
	http://www.opensource.org/licenses/mit-license.php

	ben@xoxco.com

*/

(function($) {

	var delimiter = new Array();
	
	jQuery.fn.addTag = function(value,options) {
		
			var options = jQuery.extend({focus:false},options);
			this.each(function() { 
				id = $(this).attr('id');
	
				var tagslist = $(this).val().split(delimiter[id]);
				if (tagslist[0] == '') { 
					tagslist = new Array();
				}
				value = jQuery.trim(value);
				if (value !='') { 
					
					$('<a href="#" title="Remove tag" onclick="return $(\'#'+id + '\').removeTag(\'' + escape(value) + '\');"><span class="tag">'+value + '&nbsp;&nbsp;X</span></a>').insertBefore('#'+id+'_addTag');
					tagslist.push(value);
				
					$('#'+id+'_tag').val('');
					if (options.focus) {
						$('#'+id+'_tag').focus();
					} else {		
						$('#'+id+'_tag').blur();
					}
				}
				jQuery.fn.tagsInput.updateTagsField(this,tagslist);
		
			});		
			
			return false;
		};
		
	jQuery.fn.removeTag = function(value) { 
			
			this.each(function() { 
				id = $(this).attr('id');
	
				var old = $(this).val().split(delimiter[id]);
	
				
				$('#'+id+'_tagsinput .tag').remove();
				str = '';
				for (i=0; i< old.length; i++) { 
					if (escape(old[i])!=value) { 
						str = str + delimiter[id] +old[i];
					}
				}
				
				jQuery.fn.tagsInput.importTags(this,str);
			});
					
			return false;
	
		};
	
	
	jQuery.fn.tagsInput = function(options) { 
	
		var settings = jQuery.extend({defaultText:'add a tag',height:'315px','hide':true,'delimiter':',',autocomplete:{selectFirst:false}},options);
	
		this.each(function() { 
			if (settings.hide) { 
				$(this).hide();				
			}
				
			id = $(this).attr('id')
			
			data = jQuery.extend({
				pid:id,
				real_input: '#'+id,
				holder: '#'+id+'_tagsinput',
				input_wrapper: '#'+id+'_addTag',
				fake_input: '#'+id+'_tag'
			},settings);
	
	
			delimiter[id] = data.delimiter;
	
			$('<div id="'+id+'_tagsinput" class="tagsinput"><div id="'+id+'_addTag"></div><div class="tags_clear"></div></div>').insertAfter(this);
	
			$(data.holder).css('width',settings.width);
            $(data.holder).css('height',settings.height);
            $(data.holder).css('margin-top',"10px");
	
		
			if ($(data.real_input).val()!='') { 
				jQuery.fn.tagsInput.importTags($(data.real_input),$(data.real_input).val());
			} else {
				$(data.fake_input).val($(data.fake_input).attr('default'));
				$(data.fake_input).css('color','#666666');				
			}
		});
			
		return this;
	
	};
	
	
	jQuery.fn.tagsInput.updateTagsField = function(obj,tagslist) { 
		
			id = $(obj).attr('id');
			$(obj).val(tagslist.join(delimiter[id]));
		};
	
	
	
	jQuery.fn.tagsInput.importTags = function(obj,val) {
			
			$(obj).val('');
			id = $(obj).attr('id');
			var tags = val.split(delimiter[id]);
			for (i=0; i<tags.length; i++) { 
				$(obj).addTag(tags[i],{focus:false});
			}
		};
			
})(jQuery);
