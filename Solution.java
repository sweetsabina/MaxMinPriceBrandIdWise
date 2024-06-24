package answer;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.text.DecimalFormat;


public class Solution {
	
	public static void main(String[] args) {
		
		String[] csv = {"APY,170.00","APY,185.00","AMZ,145.00","APY,130.00","AMZ,124.00","AMZ,115.00","APY,140.00"};
		String brandId;
		List<Double> allPrices;
		Map<String,List<Double>> res = new HashMap<String,List<Double>>();
		DecimalFormat df = new DecimalFormat("0.00");
		for(String c : csv) {
			brandId = c.split(",")[0];
			if(res.containsKey(brandId)) {
					allPrices = res.get(brandId);
					allPrices.add(Double.valueOf(c.split(",")[1]));
				}else{
					allPrices = new ArrayList<Double>();
					allPrices.add(Double.valueOf(c.split(",")[1]));
				}
			res.put(brandId,allPrices );
			}
		res = res.entrySet()
               .stream()
               .sorted((i1, i2)
                           -> i1.getKey().compareTo(
                               i2.getKey()))
               .collect(Collectors.toMap(
                   Map.Entry::getKey,
                   Map.Entry::getValue,
                   (e1, e2) -> e1, LinkedHashMap::new));
		String[] yelo = new String[res.size()];
		int i =0;
		for(Entry<String,List<Double>> t : res.entrySet()) {
			yelo[i] = t.getKey()+","
						+df.format(t.getValue().get(0))+","
						+df.format(t.getValue().stream().max(Comparator.naturalOrder()).get())+","
						+df.format(t.getValue().stream().min(Comparator.naturalOrder()).get())+","
						+df.format(t.getValue().get(t.getValue().size()-1)) ;
			i++;		
		}
		System.out.println(Arrays.toString(yelo));
		//return this array
		}
		
	}

