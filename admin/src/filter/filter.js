/**
 * 数组过滤器 例如 {{CHARGE | optionKV(section.charge)}}
 * @param object 例如{CHARGE:{key:"C",value:"收费"},FREE:{key: "F",value:"免费"}};
 * @param key 例如：C
 * @return {string} 例如：收费
 * */
let optionKV = (object,key) => {
    if (!object || !key){
        return "";
    }else{
        let result="";
        for (let enums in object){
            if (key===object[enums]["key"]){
                result = object[enums]["value"];
            }
        }
        return result;
    }
};
/**
 * 时长格式化
 * @param value 例如：36000
 * @returns {string} 例如：10:00:00
 */
let formatSecond = (value) => {
    value = value || 0;
    let second = parseInt(value, 10); // 秒
    let minute = 0; // 分
    let hour = 0; // 小时
    if (second > 60) {
        // 当大于60秒时，才需要做转换
        minute = Math.floor(second / 60);
        second = Math.floor(second % 60);
        if (minute > 60) {
            hour = Math.floor(minute / 60);
            minute = Math.floor(minute % 60);
        }
    } else {
        // 小于60秒时，直接显示，不需要处理
    }
    let result = "" + PrefixInteger(second, 2) + "";
    // 拼上分钟
    result = "" + PrefixInteger(minute, 2) + ":" + result;
    // 拼上小时
    result = "" + PrefixInteger(hour, 2) + ":" + result;
    return result;
};
/**
 * 格式化指定长度，前面补0
 */
function PrefixInteger(num, length) {
    return (Array(length).join('0') + num).slice(-length);
}
export default {
    optionKV,
    formatSecond
}