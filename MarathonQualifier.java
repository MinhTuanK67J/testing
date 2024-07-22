import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MarathonQualifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Nhập ngày xét duyệt từ bàn phím
        System.out.print("Nhập ngày xét duyệt (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        LocalDate reviewDate;
        
        // Kiểm tra định dạng ngày
        try {
            reviewDate = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Ngày không hợp lệ. Vui lòng nhập theo định dạng yyyy-MM-dd.");
            scanner.close();
            return;
        }

        // Nhập thời gian chạy từ bàn phím
        System.out.print("Nhập thời gian chạy (giây): ");
        int runTime = scanner.nextInt();
        
        // Nhập thứ hạng từ bàn phím
        System.out.print("Nhập thứ hạng: ");
        int ranking = scanner.nextInt();

        // Đóng Scanner
        scanner.close();

        // Gọi hàm kiểm tra kết quả
        String result = checkQualification(reviewDate, runTime, ranking);
        System.out.println(result);
    }

    public static String checkQualification(LocalDate reviewDate, int runTime, int ranking) {
        // Định nghĩa thời gian xét duyệt
        LocalDate startDate = LocalDate.of(2022, 11, 1);
        LocalDate endDate = LocalDate.of(2024, 4, 30);

        // Kiểm tra dữ liệu đầu vào không hợp lệ
        if (runTime < 0 || ranking < 0) {
            return "invalid";
        }

        // Kiểm tra ngày xét duyệt có nằm trong khoảng thời gian hợp lệ
        if (reviewDate.isBefore(startDate) || reviewDate.isAfter(endDate)) {
            return "không đạt";
        }

        // Kiểm tra chuẩn đầu vào (Cách 1)
        if (runTime <= 7690) {
            return "đạt";
        }

        // Kiểm tra Bảng xếp hạng thế giới (Cách 2)
        if (ranking <= 65) {
            return "đạt";
        }

        // Không đạt nếu không thỏa mãn cả hai cách
        return "không đạt";
    }
}
