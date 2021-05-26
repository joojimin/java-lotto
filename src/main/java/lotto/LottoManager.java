package lotto;

import exception.LottoException;
import ui.InputView;
import ui.ResultView;
import utils.*;

import java.math.BigDecimal;
import java.util.function.Predicate;


public final class LottoManager {
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;

	private final LottoGenerator lottoGenerator;

	public LottoManager() {
		lottoGenerator = new LottoGenerator(new LottoNumbersFactory(),
											DrawNumber.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
	}

	public void run() {
		try {
			startLotto();
		} catch(LottoException e) {
			ResultView.printExceptionMessage(e);
		}
	}

	private void startLotto() {
		LottoMoney lottoMoney = new LottoMoney(InputView.inputPrice());
		buyLotto(lottoMoney);
		calculateResult(new WinningLottoNumbers(inputWinningNumber(), bonusLottoNumber()),
						lottoMoney);
	}

	private void buyLotto(final LottoMoney lottoMoney) {
		LottoNumbersFactory lottoNumbersFactory = this.lottoGenerator.buy(lottoMoney);
		ResultView.printResultBuyLotto(lottoNumbersFactory);
	}

	private LottoNumber bonusLottoNumber() {
		return new LottoNumber(InputView.inputBonusNumber());
	}

	private void calculateResult(final WinningLottoNumbers winningLottoNumbers, final LottoMoney lottoMoney) {
		ResultView.printWinningLottoNumber();
		LottoResult lottoResult = this.lottoGenerator.summary(winningLottoNumbers);
		BigDecimal revenue = lottoResult.calculateRevenue(lottoMoney);
		ResultView.printCalculateRevenue(lottoResult, revenue);
	}

	private LottoNumbers inputWinningNumber() {
		String inputText = InputView.inputWinningNumber();
		SeparatedText separatedText = SeparatedText.findSeparator(inputText);
		String[] texts = StringUtils.split(separatedText.getDelimiter(), separatedText.getTexts());
		return new LottoNumbers(NumberUtils.parseInts(texts, lottoNumberCondition()));
	}

	private Predicate<Integer> lottoNumberCondition() {
		return num -> {
			if (num < LOTTO_MIN_NUMBER || num > LOTTO_MAX_NUMBER) {
				return false;
			}
			return true;
		};
	}
}
