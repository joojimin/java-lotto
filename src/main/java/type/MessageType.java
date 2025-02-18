package type;

public enum MessageType {

	INPUT_PRICE("구입금액을 입력해 주세요."),
	INPUT_USER_LOTTO_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
	INPUT_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
	INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요."),
	INPUT_USER_LOTTO("수동으로 구매할 번호를 입력해 주세요."),
	OUTPUT_LOTTO_COUNT("수동으로 %d장, 자동으로 %d개를 구매했습니다."),
	OUTPUT_RESULT("당첨 통계\n---------"),
	OUTPUT_LOTTO_REVENUE("총 수익률은 %.02f입니다."),
	OUTPUT_FAILED_LOTTO_REVENUE("(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
	;

	private final String message;

	MessageType(final String message) {
		this.message = message;
	}

	public String message() {
		return this.message;
	}
}
