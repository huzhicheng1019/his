/**
 * 消息提示
 */
package cn.gson.his.model.pojos.Power;

public class ElMessage {
    private String message="更新数据失败";
    private String type="error";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ElMessage(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public ElMessage() {
    }
}
