package logic;

public int getTotalMoney() { return 1000; } // สมมติว่ามีเงิน 1000
public List<UpgradeItem> getAvailableItems() {
    return new ArrayList<>(); // คืนค่าลิสต์ว่างไปก่อน จะได้ไม่ Error
}
public boolean purchaseItem(UpgradeItem item) { return true; }
