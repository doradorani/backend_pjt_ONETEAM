/**
 * @license Copyright (c) 2003-2023, CKSource Holding sp. z o.o. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

// CKEDITOR.editorConfig = function( config ) {
// 	// Define changes to default configuration here.
// 	// For complete reference see:
// 	// https://ckeditor.com/docs/ckeditor4/latest/api/CKEDITOR_config.html
//
// 	// The toolbar groups arrangement, optimized for two toolbar rows.
// 	config.toolbarGroups = [
// 		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
// 		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
// 		{ name: 'links' },
// 		{ name: 'insert' },
// 		{ name: 'forms' },
// 		{ name: 'tools' },
// 		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
// 		{ name: 'others' },
// 		'/',
// 		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
// 		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
// 		{ name: 'styles' },
// 		{ name: 'colors' },
// 		{ name: 'about' }
// 	];
//
// 	// Remove some buttons provided by the standard plugins, which are
// 	// not needed in the Standard(s) toolbar.
// 	config.removeButtons = 'Underline,Subscript,Superscript';
//
// 	// Set the most common block elements.
// 	config.format_tags = 'p;h1;h2;h3;pre';
//
// 	// Simplify the dialog windows.
// 	config.removeDialogTabs = 'image:advanced;link:advanced';
//
// 	// 에디터 높이 지정
// 	config.height = 400;
//
// 	// 폰트 선택상자에 한글 폰트 추가
// 	// (폰트는 세미콜론(;) 으로 구분되고 "선택 상자에 보여질 이름 / 콤마로 분리된 폰트명들" 로 구성됨)
// 	config.font_names='맑은 고딕/Malgun Gothic;굴림/Gulim;돋움/Dotum;바탕/Batang;궁서/Gungsuh;' + config.font_names;
// };

CKEDITOR.editorConfig = function( config ) {
	config.toolbarGroups = [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'about', groups: [ 'about' ] },
		{ name: 'tools', groups: [ 'tools' ] },
		'/',
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
		'/',
		{ name: 'others', groups: [ 'others' ] }

	];
	// 에디터 높이 지정
	config.height = 400;

	// 폰트 선택상자에 한글 폰트 추가
	// (폰트는 세미콜론(;) 으로 구분되고 "선택 상자에 보여질 이름 / 콤마로 분리된 폰트명들" 로 구성됨)
	config.font_names='맑은 고딕/Malgun Gothic;굴림/Gulim;돋움/Dotum;바탕/Batang;궁서/Gungsuh;' + config.font_names;
	config.removeButtons = 'Source,Save,ExportPdf,Preview,Print,PasteFromWord,ShowBlocks,About,PageBreak,Iframe,Anchor,Unlink,Language,BidiRtl,BidiLtr,CreateDiv,Blockquote,RemoveFormat,CopyFormatting,Scayt,HiddenField,ImageButton,Button,Select,Textarea,TextField,Radio,Checkbox,Form';
};
