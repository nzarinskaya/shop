package controller;
import command.GeneralCommand;
import command.PutTheGoodsInTheCartCommand;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class AccountControllerTest {
    private AccountController testSubject = new AccountController();
    @Test
    public void verifyThatCreateCommandWorksAsExpected() {
        String commandName = "PutTheGoodsInTheCart";
        HttpServletRequest httpServletRequestMock = mock(HttpServletRequest.class);
        given(httpServletRequestMock.getParameter("command")).willReturn(commandName);

        GeneralCommand command = testSubject.getCommand(httpServletRequestMock);
        assertTrue(command instanceof PutTheGoodsInTheCartCommand);
    }

}
