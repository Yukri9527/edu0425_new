package edu0425.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

public class MD5Util { // MD5���ܹ�����

	public static String textToMD5U16(String plainText) {
		String result = null;
		if (StringUtils.isBlank(plainText)) {
			return null;
		} else {
			result = textToMD5U32(plainText);
			result = result.toUpperCase().substring(8, 24);
		}

		return result;
	}

	public static String textToMD5U32(String plainText) {
		String result = null;
		if (StringUtils.isBlank(plainText)) { // ��Ϊ�գ�����null
			return null;
		} else {
			try {
				// ���Ƚ���MD5���ʵ�����ͳ�ʼ��
				MessageDigest md = MessageDigest.getInstance("MD5");
				// �Ѵ����ܵ��ַ���ת�����ֽڱ���ĸ�ʽ
				byte[] btInput = plainText.getBytes();
				// �Եõ����ֽ������д���
				md.update(btInput);
				// ���й�ϣ���� ���ؽ��
				byte[] btResult = md.digest();
				// ��ϣ���������ݽ���ƴ��
				StringBuilder sb = new StringBuilder();
				for (byte b : btResult) {
					int bt = b & 0xff;
					if (bt < 16) {
						sb.append(0);
					}
					sb.append(Integer.toHexString(bt));
				} // toString ת��
				result = sb.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(textToMD5U32("admin"));
		System.out.println(textToMD5U16("admin"));
	}

}
