package core.comm;

import java.util.ArrayList;
import java.util.Map;

import core.model.Datum;

public class RepositoryUtils {
	/**
	 * repository에 datum value 추가. keys에 idx 세팅.
	 * @param value null 그대로 저장
	 */
	public static void addValue(Map<String, Datum> data, Map<String, Integer> datumKeys, String datumKey, String value) {
		Datum datum = data.get(datumKey);
		if(datum == null) {
			datum = new Datum();
			data.put(datumKey, datum);
		}
		
		datumKeys.put(datumKey, Utils.addString(datum.getValues(), value));
	}
	
	/**
	 * repository에 parameterString 추가. keys에 idx 세팅.
	 * @param parameterString null 시 공백 저장
	 */
	public static void addParameterString(Map<String, Datum> data, Map<String, Integer> datumKeys, String parameterString) {
		Datum paramKeyDatum = data.get(Constants.DATUM_KEY.PARAMETER_KEY);
		Datum paramValueDatum = data.get(Constants.DATUM_KEY.PARAMETER_VALUE);
		
		if(paramKeyDatum == null) {
			paramKeyDatum = new Datum();
			paramKeyDatum.setIdxes(new ArrayList<Integer[]>());
			data.put(Constants.DATUM_KEY.PARAMETER_KEY, paramKeyDatum);
		}
		
		if(paramValueDatum == null) {
			paramValueDatum = new Datum();
			// 공백 데이터가 많아 idx 0으로 고정
			paramValueDatum.getValues().add("");
			paramValueDatum.setIdxes(new ArrayList<Integer[]>());
			data.put(Constants.DATUM_KEY.PARAMETER_VALUE, paramValueDatum);
		}
		
		String[] parameters = (parameterString == null ? "" : parameterString).split("&", -1);
		Integer[] paramKeyIdxes = new Integer[parameters.length];
		Integer[] paramValueIdxes = new Integer[parameters.length];
		
		for(int i = 0; i < parameters.length; i++) {
			String[] keyValuePair = parameters[i].split("=", 2);
			paramKeyIdxes[i] = Utils.addString(paramKeyDatum.getValues(), keyValuePair.length < 2 ? "" : keyValuePair[0]);
			paramValueIdxes[i] = Utils.addString(paramValueDatum.getValues(), keyValuePair[keyValuePair.length - 1]);
		}
		
		datumKeys.put(Constants.DATUM_KEY.PARAMETER_KEY, Utils.addIntegers(paramKeyDatum.getIdxes(), paramKeyIdxes));
		datumKeys.put(Constants.DATUM_KEY.PARAMETER_VALUE, Utils.addIntegers(paramValueDatum.getIdxes(), paramValueIdxes));
	}
	
	/**
	 * repository에 uri 추가. keys에 idx 세팅.
	 * @param uri 파라미터 없을 경우 url만 저장, null 시 공백 저장
	 */
	public static void addURI(Map<String, Datum> data, Map<String, Integer> datumKeys, String uri) {
		String[] uriSplitArr = (uri == null ? "" : uri).split("\\?", 2);
		
		addValue(data, datumKeys, Constants.DATUM_KEY.URL, uriSplitArr[0]);
		if(uriSplitArr.length >= 2) {
			addParameterString(data, datumKeys, uriSplitArr[1]);
		}
	}
}
