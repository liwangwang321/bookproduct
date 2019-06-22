package com.liwangwang.util;

import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * ƴ�������࣬�ܽ�����ת����ƴ��������ĸ
 */
public class PinYinUtil {
	/* ���������жϵ�������ʽ */
	private static final String regexStr = "[\u4e00-\u9fa5]";

	/**
	 * ��һ���ַ����еĺ���ת����ƴ������ĸ���Ǻ����򲻱�
	 * 
	 * @param cn
	 *            String
	 * @return String
	 */
	public static String toPinyin(String cn) {
		String pinyin = null;
		if (null == cn || 0 == cn.trim().length()) {
			return pinyin;
		}

		/* ȥ���ַ���ǰ��Ŀո� */
		cn = cn.trim();
		char[] chineseCharacterArr = cn.toCharArray(); // ת���ɺ����ַ�����
		char[] letteCharacterArr = new char[chineseCharacterArr.length]; // ��ĸ�ַ�����
		for (int i = 0; i < chineseCharacterArr.length; i++) {
			// �õ�����ƴ��������ĸ
			letteCharacterArr[i] = getFirstLetterFromPinyin(chineseCharacterArr[i]);
		}

		if (0 != letteCharacterArr.length) {
			pinyin = new String(letteCharacterArr);
			pinyin = pinyin.toUpperCase();
		}
		return pinyin;
	}

	/* �õ�һ�����ֵ�ƴ��������ĸ */
	private static char getFirstLetterFromPinyin(char cn) {
		// �ж�cn�Ƿ�Ϊһ���Ϸ��ĺ���,������ֱ�ӷ���cn
		if (!isChineseCharacters(cn)) {
			return cn;
		}

		String[] pyArr = PinyinHelper.toHanyuPinyinStringArray(cn);
		char py = pyArr[0].charAt(0);
		return py;
	}

	/**
	 * �ж��ַ��Ƿ�Ϊһ������
	 * 
	 * @param cn
	 *            char
	 * @return boolean
	 */
	public static boolean isChineseCharacters(char cn) {
		boolean b = false;
		if (Pattern.matches(regexStr, String.valueOf(cn))) {
			b = true;
		}
		return b;
	}

	public static void main(String[] args) {
		String s = "交流交流";
		System.out.println(PinYinUtil.toPinyin(s).toLowerCase());
	}

}