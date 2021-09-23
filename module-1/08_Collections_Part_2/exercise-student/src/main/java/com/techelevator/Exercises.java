package com.techelevator;

import java.util.*;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {

		Map<String, String> animalMap = new HashMap<>();
		animalMap.put("rhino", "Crash");
		animalMap.put("giraffe", "Tower");
		animalMap.put("elephant", "Herd");
		animalMap.put("lion", "Pride");
		animalMap.put("crow", "Murder");
		animalMap.put("pigeon", "Kit");
		animalMap.put("flamingo", "Pat");
		animalMap.put("deer", "Herd");
		animalMap.put("dog", "Pack");
		animalMap.put("crocodile", "Float");

		if (animalName != null) {
			animalName = animalName.toLowerCase();
			if (animalMap.containsKey(animalName)) {
				return animalMap.get(animalName);
			}
		}
		return "unknown";
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {

		Map<String, Double> itemsOnSaleMap = new HashMap<>();
		itemsOnSaleMap.put("KITCHEN4001", .20);
		itemsOnSaleMap.put("LIVINGROOM", .15);
		itemsOnSaleMap.put("KITCHEN6073", .40);
		itemsOnSaleMap.put("BEDROOM3434", .60);
		itemsOnSaleMap.put("BATH0073", .15);

		if (itemNumber != null) {
			itemNumber = itemNumber.toUpperCase();
			if (itemsOnSaleMap.containsKey(itemNumber)) {
				return itemsOnSaleMap.get(itemNumber);
			}
		}
		return 0.0;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		if (peterPaul.get("Peter") > 0 && peterPaul.get("Paul") < 1000) {
			if (peterPaul.get("Peter") % 2 == 1) {
				peterPaul.put("Peter", peterPaul.get("Peter")/2 + 1);
				peterPaul.put("Paul", peterPaul.get("Paul") + peterPaul.get("Peter") - 1);
				return peterPaul;
			} else {
				peterPaul.put("Peter", peterPaul.get("Peter")/2);
				peterPaul.put("Paul", peterPaul.get("Paul") + peterPaul.get("Peter"));
				return peterPaul;
			}

		}
		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		if (peterPaul.get("Peter") >= 5000 && peterPaul.get("Paul") >= 10000) {
			int petersWorth = peterPaul.get("Peter")/4;
			peterPaul.put("Peter", peterPaul.get("Peter") - peterPaul.get("Peter")/4);

			int paulsWorth = peterPaul.get("Paul")/4;
			peterPaul.put("Paul", peterPaul.get("Paul") - peterPaul.get("Paul")/4);

			peterPaul.put("PeterPaulPartnership", petersWorth + paulsWorth);
			return peterPaul;
		}
		return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> begEndMap = new HashMap<>();
		for (String word : words) {
			begEndMap.put(word.substring(0, 1), word.substring(word.length() - 1));
		}
		return begEndMap;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {


		Map<String, Integer> stringTimes = new HashMap<>();

		for (String word : words) {
			stringTimes.put(word, 0);
		}

		for (String word : words) {
			stringTimes.put(word, stringTimes.get(word) + 1);
		}
		return stringTimes;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {

		Map<Integer, Integer> intCount = new HashMap<>();

		for (int integer : ints) {
			intCount.put(integer, 0);
		}

		for (int integer : ints) {
			intCount.put(integer, intCount.get(integer) + 1);
		}
		return intCount;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {

		// create map for tracking word count
		// create output map
		Map<String, Integer> multiplesCount	 = new HashMap<>();
		Map<String, Boolean> trueMultiples = new HashMap<>();

		// puts input words into multiplesCount as keys, all values 0
		for (String word : words) {
			multiplesCount.put(word, 0);
		}
		System.out.print(multiplesCount.values());

		// increments values to equal accurate count
		for (String word : words) {
			multiplesCount.put(word, multiplesCount.get(word) + 1);
		}
		System.out.print(multiplesCount.values());

		// iterates through keys of multiple count and assigns booleans depending on the number of the value from multiplesCount
		for (String word : multiplesCount.keySet()) {
			if(multiplesCount.get(word) > 1) {
				trueMultiples.put(word, true);
			} else {
				trueMultiples.put(word, false);
			}

		}
		System.out.println(trueMultiples);

		return trueMultiples;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {

		Map<String, Integer> consolidatedWarehouse = new HashMap<>();

		// put main keys in consolidated
		for (String key : mainWarehouse.keySet()) {
			consolidatedWarehouse.put(key, 0);
		}

		// put remote keys in consolidated
		for (String key : remoteWarehouse.keySet()) {
			consolidatedWarehouse.put(key, 0);
		}

		// combine values with keys
		for (String key : consolidatedWarehouse.keySet()) {
			if(mainWarehouse.containsKey(key) && remoteWarehouse.containsKey(key)) {
				consolidatedWarehouse.put(key, (mainWarehouse.get(key) + remoteWarehouse.get(key)));
			} else if (mainWarehouse.containsKey(key)){
				consolidatedWarehouse.put(key, mainWarehouse.get(key));
			} else {
				consolidatedWarehouse.put(key, remoteWarehouse.get(key));
			}
		}
		return consolidatedWarehouse;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {

		Map<String, Integer> outputMap = new HashMap<>();

		for (String key : words) {
			int count = 0;
			for (int i = 0; i < key.length() - 2; i++) {
				if (key.substring(i, i + 2).equals(key.substring(key.length()-2))) {
					count++;
				}
			}
			outputMap.put(key, count);
		}
		return outputMap;
	}

}