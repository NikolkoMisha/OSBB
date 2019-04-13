package project.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class CategoryFilter {

	private List<Integer> commodityIds = new ArrayList<>();

	public List<Integer> getCommodityIds() {
		return commodityIds;
	}

	public void setCommodityIds(List<Integer> commodityIds) {
		this.commodityIds = commodityIds;
	}
	
}
