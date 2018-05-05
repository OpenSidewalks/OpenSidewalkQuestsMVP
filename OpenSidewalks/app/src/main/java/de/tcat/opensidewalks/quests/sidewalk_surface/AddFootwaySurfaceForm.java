package de.tcat.opensidewalks.quests.sidewalk_surface;

import de.tcat.opensidewalks.quests.AbstractQuestFormAnswerFragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import de.tcat.opensidewalks.R;
import de.tcat.opensidewalks.view.GroupedImageSelectAdapter;

/**
 * Created by Neelam Purswani on 14-01-2018.
 */

public class AddFootwaySurfaceForm extends AbstractQuestFormAnswerFragment {
    public static final String SURFACE = "surface";

    private final AddFootwaySurfaceForm.Surface[] SURFACES = new AddFootwaySurfaceForm.Surface[] {
            new AddFootwaySurfaceForm.Surface("paved", R.drawable.panorama_surface_paved, R.string.quest_surface_value_paved, new AddFootwaySurfaceForm.Surface[]{
                    new AddFootwaySurfaceForm.Surface("asphalt", R.drawable.surface_asphalt, R.string.quest_surface_value_asphalt),
                    new AddFootwaySurfaceForm.Surface("concrete", R.drawable.surface_concrete, R.string.quest_surface_value_concrete),
                    new AddFootwaySurfaceForm.Surface("sett", R.drawable.surface_sett, R.string.quest_surface_value_sett),
                    new AddFootwaySurfaceForm.Surface("paving_stones", R.drawable.surface_paving_stones, R.string.quest_surface_value_paving_stones),
                    new AddFootwaySurfaceForm.Surface("cobblestone", R.drawable.surface_cobblestone, R.string.quest_surface_value_cobblestone),
                    new AddFootwaySurfaceForm.Surface("wood", R.drawable.surface_wood, R.string.quest_surface_value_wood),
            }),
            new AddFootwaySurfaceForm.Surface("unpaved", R.drawable.panorama_surface_unpaved, R.string.quest_surface_value_unpaved, new AddFootwaySurfaceForm.Surface[]{
                    new AddFootwaySurfaceForm.Surface("compacted", R.drawable.surface_compacted, R.string.quest_surface_value_compacted),
                    new AddFootwaySurfaceForm.Surface("gravel", R.drawable.surface_gravel, R.string.quest_surface_value_gravel),
                    new AddFootwaySurfaceForm.Surface("fine_gravel", R.drawable.surface_fine_gravel, R.string.quest_surface_value_fine_gravel),
                    new AddFootwaySurfaceForm.Surface("pebblestone", R.drawable.surface_pebblestone, R.string.quest_surface_value_pebblestone),
                    new AddFootwaySurfaceForm.Surface("grass_paver", R.drawable.surface_grass_paver, R.string.quest_surface_value_grass_paver),
            }),
            new AddFootwaySurfaceForm.Surface("ground", R.drawable.panorama_surface_ground, R.string.quest_surface_value_ground, new AddFootwaySurfaceForm.Surface[]{
                    new AddFootwaySurfaceForm.Surface("dirt", R.drawable.surface_dirt, R.string.quest_surface_value_dirt),
                    new AddFootwaySurfaceForm.Surface("grass", R.drawable.surface_grass, R.string.quest_surface_value_grass),
                    new AddFootwaySurfaceForm.Surface("sand", R.drawable.surface_sand, R.string.quest_surface_value_sand),
            }),
    };

    private GroupedImageSelectAdapter imageSelector;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        View contentView = setContentView(R.layout.quest_street_surface);

        RecyclerView surfaceSelect = contentView.findViewById(R.id.surfaceSelect);
        imageSelector = new GroupedImageSelectAdapter(Arrays.<GroupedImageSelectAdapter.Item>asList(SURFACES));
        surfaceSelect.setAdapter(imageSelector);
        surfaceSelect.setNestedScrollingEnabled(false);

        return view;
    }

    @Override protected void onClickOk()
    {
        Bundle answer = new Bundle();
        if(getSelectedSurface() != null)
        {
            answer.putString(SURFACE, getSelectedSurface().value);
        }
        applyFormAnswer(answer);
    }

    @Override public boolean hasChanges()
    {
        return getSelectedSurface() != null;
    }

    private AddFootwaySurfaceForm.Surface getSelectedSurface()
    {
        return (AddFootwaySurfaceForm.Surface) imageSelector.getSelectedItem();
    }

    private static class Surface extends GroupedImageSelectAdapter.Item
    {
        public final String value;

        public Surface(String value, int drawableId, int titleId)
        {
            super(drawableId, titleId);
            this.value = value;
        }

        public Surface(String value, int drawableId, int titleId, GroupedImageSelectAdapter.Item[] items)
        {
            super(drawableId, titleId, items);
            this.value = value;
        }
    }
}
