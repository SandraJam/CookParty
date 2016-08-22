package com.example.octo_sdu.cookpartyv3.back;

import android.content.Context;

import com.example.octo_sdu.cookpartyv3.ingredients.back.MeasuresRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class MainDependenciesTest {
    MeasuresRepository measuresRepository;
    MainDependencies mainDependencies;
    Context context;

    @Before
    public void setUp() throws Exception {
        measuresRepository = mock(MeasuresRepository.class);
        context = mock(Context.class);
        mainDependencies = new MainDependencies(measuresRepository);
    }

    @Test
    public void testCheckFirstTimeWhenNot() {
        Mockito.when(measuresRepository.checkFirstTime()).thenReturn(5);
        mainDependencies.checkFirstTime(context);
    }

    @Test
    public void testCheckFirstTimeWhenYes() {

    }
}