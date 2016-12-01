package ua.training.controllers;

import org.junit.Before;
import org.junit.Test;
import ua.training.models.Model;
import ua.training.models.ScannerAdapter;
import ua.training.views.View;

import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControllerTest {

    private Model model;
    private View view;
    private ScannerAdapter scanner;

    private Controller controller;

    @Before
    public void before() {
        model = mock(Model.class);
        view = mock(View.class);
        scanner = mock(ScannerAdapter.class);
        controller = new Controller(model, view);
        controller.setScanner(scanner);
    }

    @Test
    public void testReadUserNumber() {
        int returnValue = new Random().nextInt();
        when(scanner.next()).thenReturn(String.valueOf(returnValue))
                            .thenReturn("abc21");

        assertEquals(controller.readUserNumber(), returnValue);

        assertEquals(controller.readUserNumber(), -1);
        verify(view).showMessage(View.ERROR_INPUT_MESSAGE);
    }

    @Test
    public void testSetRange() {
        when(scanner.next()).thenReturn("0")
                            .thenReturn("100")
                            .thenReturn("abc")
                            .thenReturn("xyz")
                            .thenReturn("50")
                            .thenReturn("51")
                            .thenReturn("50")
                            .thenReturn("52");

        controller.setRange();
        verify(model).setMinBarrier(0);
        verify(model).setMaxBarrier(100);

        controller.setRange();
        verify(view, times(3)).showMessage(View.ERROR_AND_REPEAT_MESSAGE);
        verify(model).setMinBarrier(50);
        verify(model).setMaxBarrier(52);
    }

    @Test
    public void testCheckNumberForEquality() {
        when(scanner.next()).thenReturn("40");
        int userNumber = controller.readUserNumber();
        when(model.getMinBarrier()).thenReturn(0);
        when(model.getMaxBarrier()).thenReturn(100);
        when(model.isNumbersEqual(userNumber))
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(-1);

        controller.checkNumberForEquality();

        verify(view).showMessageWithRange(View.RANGE_MESSAGE, 0, 100);

        verify(view).showMessage(View.CONGRATULATION_MESSAGE);
        verify(model).getStatistics();

        controller.checkNumberForEquality();
        verify(view).showMessage(View.HIGHER_NUMBER);
        verify(model).setMaxBarrier(userNumber);

        controller.checkNumberForEquality();
        verify(view).showMessage(View.LOWER_NUMBER);
        verify(model).setMinBarrier(userNumber);
    }

}
