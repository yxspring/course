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
export default {
    optionKV
}