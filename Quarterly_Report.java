import java.util.*;

public class Quarterly_Report {
    public static void main(String[] args) {
        int[][] sales = {
            {67, 63, 78, 78, 104, 103, 150, 120, 117, 115, 120, 179},
            {65, 67, 56, 45, 56, 72, 90, 81, 80, 72, 82, 65},
            {63, 63, 65, 71, 73, 69, 50, 77, 70, 89, 78, 69},
            {18, 24, 22, 19, 17, 16, 20, 23, 18, 15, 30, 40},
            {16, 23, 21, 19, 20, 19, 20, 15, 16, 22, 17, 22}
        };
        
        String[] department = {"Electrical", "Kitchen", "Bathroom", "Soft Furnishing", "Accessories"};
        
        LinkedHashMap<String, int[]> totalSales = new LinkedHashMap<>();
        
        for (int i = 0; i < department.length; i++) {
            totalSales.put(department[i], sales[i]);
        }

        System.out.println("TOTAL SALES");
        for (Map.Entry<String, int[]> sale : totalSales.entrySet()) {
            String key = sale.getKey();
            int[] departmentSales = sale.getValue();
            int Q1_sales = departmentSales[0] + departmentSales[1] + departmentSales[2];
            int Q2_sales = departmentSales[3] + departmentSales[4] + departmentSales[5];
            int Q3_sales = departmentSales[6] + departmentSales[7] + departmentSales[8];
            int Q4_sales = departmentSales[9] + departmentSales[10] + departmentSales[11];
            System.out.println(key + " sales for 1st Quarter: £" + Q1_sales*1000);
            System.out.println(key + " sales for 2nd Quarter: £" + Q2_sales*1000);
            System.out.println(key + " sales for 3rd Quarter: £" + Q3_sales*1000);
            System.out.println(key + " sales for 4th Quarter: £" + Q4_sales*1000);
            System.out.println("");
        }

        System.out.println("");
        
        System.out.println("TAX PAYABLE:");
        for (Map.Entry<String, int[]> sale : totalSales.entrySet()) {
            String key = sale.getKey();
            int[] departmentSales = sale.getValue();
            int Q1_sales = departmentSales[0] + departmentSales[1] + departmentSales[2];
            int Q2_sales = departmentSales[3] + departmentSales[4] + departmentSales[5];
            int Q3_sales = departmentSales[6] + departmentSales[7] + departmentSales[8];
            int Q4_sales = departmentSales[9] + departmentSales[10] + departmentSales[11];
            int Q1_tax = (int) (1000*(Q1_sales * 0.17));
            int Q2_tax = (int) (1000*(Q2_sales * 0.17));
            int Q3_tax = (int) (1000*(Q3_sales * 0.17));
            int Q4_tax = (int) (1000*(Q4_sales * 0.17));
            System.out.println(key + " tax for 1st Quarter: £" + Q1_tax);
            System.out.println(key + " tax for 2nd Quarter: £" + Q2_tax);
            System.out.println(key + " tax for 3rd Quarter: £" + Q3_tax);
            System.out.println(key + " tax for 4th Quarter: £" + Q4_tax);
            System.out.println("");



        }

        System.out.println("");

        System.out.println("NEW SALES TARGETS:");

        for (Map.Entry<String, int[]> sale : totalSales.entrySet()) {
            String key = sale.getKey();
            int[] departmentSales = sale.getValue();
            int Q4_sales = departmentSales[9] + departmentSales[10] + departmentSales[11];
            int salesTarget = (int) (Q4_sales * 1000 * 0.12);
            System.out.println(key + " new sales target: £" + salesTarget);
        }
        
    }

}
