package com.nutfreedom.springtest.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ListMockTest {
    @Mock
    private List<String> mock;

    @Mock
    private ArrayList<String> arrayListMock;

    @Spy
    private ArrayList<String> arrayListSpy;

    @Test
    public void sizeBasic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameter() {
        when(mock.get(0)).thenReturn("Freedom");
        assertEquals("Freedom", mock.get(0));
        assertNull(mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("Freedom");
        assertEquals("Freedom", mock.get(0));
        assertEquals("Freedom", mock.get(1));
    }

    @Test
    public void verificationBasic() {
        mock.get(0);
        mock.get(1);
        verify(mock).get(0);
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, times(2)).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        mock.add("Freedom");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("Freedom", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        mock.add("Freedom1");
        mock.add("Freedom2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("Freedom1", allValues.get(0));
        assertEquals("Freedom2", allValues.get(1));
    }

    @Test
    public void mocking() {
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("FreedomMock1");
        arrayListMock.add("FreedomMock2");
        System.out.println(arrayListMock.size()); // 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size()); // 5
    }

    @Test
    public void spying() {
        arrayListSpy.add("FreedomSpy0");
        System.out.println(arrayListSpy.get(0)); // FreedomSpy0
        System.out.println(arrayListSpy.size()); // 1
        arrayListSpy.add("FreedomSpy1");
        arrayListSpy.add("FreedomSpy2");
        System.out.println(arrayListSpy.size()); // 3
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5
        arrayListSpy.add("FreedomSpy3");
        System.out.println(arrayListSpy.size()); // 5
        verify(arrayListSpy).add("FreedomSpy0");
    }
}
