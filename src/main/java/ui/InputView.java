package ui;

import exception.LottoException;
import type.LottoExceptionType;
import type.MessageType;
import utils.ConsoleUtils;

public class InputView {

	private InputView() {
		// empty
	}

	public static int inputPrice() {
		try {
			return ConsoleUtils.nextInt(MessageType.INPUT_PRICE.message());
		} catch(Exception e) {
			throw LottoException.of(LottoExceptionType.ONLY_NUMBER);
		}
	}

	public static int inputUserLottoCount(){
		ConsoleUtils.printLine();
		try {
			return ConsoleUtils.nextInt(MessageType.INPUT_USER_LOTTO_COUNT.message());
		} catch(Exception e) {
			throw LottoException.of(LottoExceptionType.ONLY_NUMBER);
		}
	}

	public static String inputWinningNumber() {
		try {
			return ConsoleUtils.nextString(MessageType.INPUT_WINNING_NUMBER.message());
		} catch(Exception e) {
			throw LottoException.of(LottoExceptionType.WRONG_INPUT_TEXT);
		}
	}

	public static int inputBonusNumber() {
		try {
			return ConsoleUtils.nextInt(MessageType.INPUT_BONUS_NUMBER.message());
		} catch(Exception e) {
			throw LottoException.of(LottoExceptionType.WRONG_INPUT_TEXT);
		}
	}

	public static String inputUserLottoNumber() {
		try {
			return ConsoleUtils.nextString();
		} catch(Exception e) {
			throw LottoException.of(LottoExceptionType.WRONG_INPUT_TEXT);
		}
	}

	public static void printUserLotto(){
		ConsoleUtils.printLine();
		ConsoleUtils.printLine(MessageType.INPUT_USER_LOTTO.message());
	}
}
