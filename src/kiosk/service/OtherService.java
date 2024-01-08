package kiosk.service;

import kiosk.model.Basket;
import kiosk.model.Database;
import kiosk.model.Item;
import kiosk.others.Invalidate;
import kiosk.view.OutputView;

import java.util.Map;

public class OtherService {
    private final OutputView outputView;

    public OtherService() {
        outputView = new OutputView();
    }

    public void orderMenu() {
        if(Basket.getInstance().isEmpty()) {
            outputView.basketEmpty();
            return;
        }
        outputView.orderBasket(Basket.getInstance().getBasket(), Basket.getInstance().getTotalPrice());
        choiceOrderNumber();
    }

    public void cancelMenu() {
        if(Basket.getInstance().isEmpty()) {
            outputView.basketEmpty();
            return;
        }
        outputView.cancelBasket();
        choiceCancelNumber();
    }

    public void sellMenu() {
        if(Database.getInstance().isEmpty()) {
            outputView.databaseEmpty();
            return;
        }
        outputView.databaseInfo(Database.getInstance().getSellInfo(),Database.getInstance().getTotalPrice());
        choiceSellNumber();
    }

    private void choiceOrderNumber() {
        int number = Invalidate.typeException();

        if(number == 2) {
            outputView.backToPrev();
            return;
        }
        putDataBase();
        outputView.orderComplete(Database.getInstance().getWaitingNumber());
    }

    private void choiceCancelNumber() {
        int number = Invalidate.typeException();

        if(number == 2) {
            outputView.backToPrev();
            return;
        }
        Basket.getInstance().clearBasket();
        outputView.cancelComplete();
    }

    private void choiceSellNumber() {
        Invalidate.sellException();
        outputView.backToPrev();
    }

    private void putDataBase() {
        // database에 산 정보들을 넣기
        for(Map.Entry<Item,Integer> items : Basket.getInstance().getBasket().entrySet()) {
            if(!Database.getInstance().containItem(items.getKey(),items.getValue())) {
                Database.getInstance().addItem(items.getKey(), items.getValue());
            }
        }

        // 장바구니는 이제 정리
        Basket.getInstance().clearBasket();
    }

}
