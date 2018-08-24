package indi.goddess.shoppingmall2.utils.user;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 *
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 */
public class IndustrySMS {
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;

	/**
	 * 验证码通知短信
	 */
	//IndustrySMS.execute(username, orderFname, resorder.getDeliverytime(), resorder.getTel());
	public static void execute(String code, String to) {
		String smsContent = "【品优购】登录验证码：" + code + "，如非本人操作，请忽略此短信。";
		String tmpSmsContent = null;
		try {
			tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
		} catch (Exception e) {
			System.err.println("短信发送失败");
		}
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		HttpUtil.post(url, body);
		// System.out.println("result:" + System.lineSeparator() + result);
	}
}
