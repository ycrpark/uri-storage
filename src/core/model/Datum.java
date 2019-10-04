package core.model;

import java.util.ArrayList;
import java.util.List;

public class Datum {
	/**
	 * 데이터 저장
	 */
	private List<String> values = new ArrayList<>();
	/**
	 * 조합 데이터일 때, values의 index
	 * uri 파라미터 조합 시 사용
	 */
	private List<Integer[]> idxes;
	
	public List<String> getValues() {
		return values;
	}
	
	public void setValues(List<String> values) {
		this.values = values;
	}
	
	public List<Integer[]> getIdxes() {
		return idxes;
	}
	
	public void setIdxes(List<Integer[]> idxes) {
		this.idxes = idxes;
	}
	
}
