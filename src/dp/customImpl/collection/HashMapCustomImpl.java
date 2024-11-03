package dp.customImpl.collection;

public class HashMapCustomImpl<K, V> {
	private Entry<K, V>[] table; // Array of Entry.
	private int capacity = 4; // Initial capacity of HashMap

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	@SuppressWarnings("unchecked")
	public HashMapCustomImpl() {
		table = new Entry[capacity];
	}

	/**
	 * Method allows you put key-value pair in HashMapCustom. If the map already
	 * contains a mapping for the key, the old value is replaced.
	 */
	public void put(K newKey, V data) {
		if (newKey == null)
			return; // does not allow to store null.

		// calculate hash of key.
		int hash = hash(newKey);
		// create new entry.
		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

		// if table location does not contain any entry, store entry there.
		if (table[hash] == null) {
			table[hash] = newEntry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			while (current != null) { // we have reached last entry of bucket.
				if (current.key.equals(newKey)) {
					if (previous == null) { // node has to be insert on first of bucket.
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					} else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	public V get(K key) {
		int hash = hash(key);
		if (table[hash] == null) {
			return null;
		} else {
			Entry<K, V> temp = table[hash];
			while (temp != null) {
				if (temp.key.equals(key))
					return temp.value;
				temp = temp.next; // return value corresponding to key.
			}
			return null; // returns null if key is not found.
		}
	}

	public boolean remove(K deleteKey) {

		int hash = hash(deleteKey);

		if (table[hash] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			while (current != null) { // we have reached last entry node of bucket.
				if (current.key.equals(deleteKey)) {
					if (previous == null) { // delete first entry node.
						table[hash] = table[hash].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}

	}

	public void display() {
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				Entry<K, V> entry = table[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
					entry = entry.next;
				}
			}
		}

	}

	/**
	 * Method implements hashing functionality, which helps in finding the
	 * appropriate bucket location to store our data.
	 */
	private int hash(K key) {
		int hc = key.hashCode();
		System.out.println("HC % CAP : " + hc + " % " + capacity + " => " + Math.abs(key.hashCode()) % capacity);
		return Math.abs(key.hashCode()) % capacity;
	}

	public static void main(String[] args) {
		HashMapCustomImpl<Integer, Integer> hashMapCustom = new HashMapCustomImpl<Integer, Integer>();
		hashMapCustom.put(100, 12);
		hashMapCustom.put(101, 24);
		hashMapCustom.put(102, 36);
		hashMapCustom.put(103, 48);
		hashMapCustom.put(104, 60);

		System.out.println("value corresponding to key 100" + hashMapCustom.get(100));
		System.out.println("value corresponding to key 200=" + hashMapCustom.get(200));

		System.out.print("Displaying : ");
		hashMapCustom.display();

		System.out.println("\n\nvalue corresponding to key 104 removed: " + hashMapCustom.remove(101));
		System.out.println("value corresponding to key 600 removed: " + hashMapCustom.remove(600));

		System.out.print("Displaying : ");
		hashMapCustom.display();
	}

}
