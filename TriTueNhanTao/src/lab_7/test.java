package lab_7;


public class test {

	    public static void main(String[] args) {
	        GA_NQueenAlgo ga = new GA_NQueenAlgo();
	        Node result = ga.execute();
	        if (result != null && result.getH() == 0) {
	            System.out.println("Thử nghiệm đã thành công. Đã được tìm thấy:");
	            result.displayBoard();
	        } else {
	            System.out.println("Thử nghiệm thất bại. Không tìm thấy");
	            if (result != null) {
	                result.displayBoard();
	                System.out.println(result.getH());
	            }
	        }
	    }
}