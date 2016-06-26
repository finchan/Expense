function isNullEmpty(value) {
    return (value == null || value == "undefined" || value == "") ? true : false;
}

function dateNumericFormatter(date){
    date = new Date(date);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}

function dateFormatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}

function dateParser(s) {
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0]);
    var m = parseInt(ss[1]);
    var d = parseInt(ss[2]);
    if ( !isNaN(y) && !isNaN(m) && !isNaN(d)) {
        return new Date(y, m-1, d);
    } else {
        return new Date();
    }
}

function formatChineseCurrency( cur ) {
    return '￥' + cur.toFixed(2);
}

/*******************************************************************************
 *Easy UI related functions
*******************************************************************************/
easyui = {
    customized: {
        functions: {
            ajaxDateFormatter: function (value, row, index) {
                return dateNumericFormatter(value);
            },
            ajaxCategoryFormatter: function (value, row, index) {
                if (isNullEmpty(value)) {
                    return "";
                } else {
                    return value.name;
                }
            },
            ajaxSubCategoryFormatter: function (value, row, index) {
                if (isNullEmpty(value)) {
                    return "";
                } else {
                    return value.name;
                }
            }
        }, events: {
            binding: {
                click: function (buttonId) {
                    if (buttonId == "searchExpense") {
                        $('#' + buttonId).click(function () {
                            var isInvalid = isNullEmpty($('#date').datebox('getValue')) &&
                                isNullEmpty($('#startDate').datebox('getValue')) &&
                                isNullEmpty($('#endDate').datebox('getValue'));
                            if(isInvalid){
                                $('#date').datebox('validate');
                                return;
                            }
                            var dg = $("#dg");
                            dg.datagrid({
                                url: "getMonthlyData",
                                queryParams: {
                                    date: $("#date").textbox('getValue'),
                                    startDate: $('#startDate').textbox('getValue'),
                                    endDate: $('#endDate').textbox('getValue'),
                                    category: $('#category').combo('getValue'),
                                    subCategory: $('#subCategory').combo('getValue')
                                },
                                method: 'post'
                            });
                        });
                    }
                }
            }
        }, formatter: {
            datagrid: {
                currencyStyle: function (value, row, index) {
                    if (value < 0) {
                        return 'color: red;';
                    }
                }, currencyFormat: function (value, row, index ) {
                    return formatChineseCurrency(value);
                }
            }
        }
    }
};
ef = easyui.customized.functions;
ebe = easyui.customized.events.binding;
efd = easyui.customized.formatter.datagrid;
/*******************************************************************************
 *Easy UI Validate Functions
 *******************************************************************************/
jQuery(document).ready(function () {

    jQuery.cachedScript = function( url, options ) {
        // Allow user to set any option except for dataType, cache, and url
        options = $.extend( options || {}, {
            dataType: "script",
            cache: true,
            url: url
        });
        // Use $.ajax() since it is more flexible than $.getScript
        // Return the jqXHR object so we can chain callbacks
        return jQuery.ajax( options );
    };

    $.extend($.fn.validatebox.defaults.rules, {
        exactDate: {
            validator: function (value, param) {
                // var date = $('#'+ param[0]).datebox('getValue');
                // var startDate = $('#'+ param[1]).datebox('getValue');
                // var endDate = $('#' + param[2]).datebox('getValue');
                var date = $('#'+ param[0]).val( );
                var startDate = $('#'+ param[1]).val( );
                var endDate = $('#' + param[2]).val( );
                if (isNullEmpty(date)) {
                    if (isNullEmpty(startDate) || isNullEmpty(endDate)) {
                        return false;
                    }
                    if(!isNullEmpty(startDate) && isNullEmpty(endDate)) {
                        return false;
                    }
                    if(isNullEmpty(startDate) && !isNullEmpty(endDate)) {
                        return false;
                    }
                }else {
                    if(!isNullEmpty(startDate) || !isNullEmpty(endDate)) {
                        return false;
                    }
                }
                return true;
            },
            message: 'Date, StartDate, EndDate are not correct!'
        },
        startDate: {
            validator: function (value, param) {
                // var date = $('#'+ param[0]).datebox('getValue');
                // var startDate = $('#'+ param[1]).datebox('getValue');
                // var endDate = $('#' + param[2]).datebox('getValue');
                var date = $('#'+ param[0]).val( );
                var startDate = $('#'+ param[1]).val( );
                var endDate = $('#' + param[2]).val( );
                if (isNullEmpty(startDate)){
                    if (!isNullEmpty(date) && !isNullEmpty(endDate)){
                        return false;
                    }
                    if (isNullEmpty(date) && !isNullEmpty(endDate)){
                        return false;
                    }
                    if(isNullEmpty(date) && isNullEmpty(endDate)){
                        return false;
                    }
                }else{
                    if (!isNullEmpty(date) && isNullEmpty(endDate)){
                        return false;
                    }
                    if (!isNullEmpty(date) && !isNullEmpty(endDate)){
                        return false;
                    }
                    if (isNullEmpty(date) && isNullEmpty(endDate)){
                        return false;
                    }
                }
                return true;
            },
            message: 'Date, StartDate, EndDate are not correct!'
        },
        endDate: {
            validator: function (value, param) {
                // var date = $('#'+ param[0]).datebox('getValue');
                // var startDate = $('#'+ param[1]).datebox('getValue');
                // var endDate = $('#' + param[2]).datebox('getValue');
                var date = $('#'+ param[0]).val( );
                var startDate = $('#'+ param[1]).val( );
                var endDate = $('#' + param[2]).val( );
                
                if (isNullEmpty(endDate)){
                    if (!isNullEmpty(date) && !isNullEmpty(startDate)){
                        return false;
                    }
                    if (isNullEmpty(date) && !isNullEmpty(startDate)){
                        return false;
                    }
                    if(isNullEmpty(date) && isNullEmpty(startDate)){
                        return false;
                    }
                }else{
                    if (!isNullEmpty(date) && isNullEmpty(startDate)){
                        return false;
                    }
                    if (!isNullEmpty(date) && !isNullEmpty(startDate)){
                        return false;
                    }
                    if (isNullEmpty(date) && isNullEmpty(startDate)){
                        return false;
                    }
                }
                return true;
            },
            message: 'Date, StartDate, EndDate are not correct!'
        }
    });
});
