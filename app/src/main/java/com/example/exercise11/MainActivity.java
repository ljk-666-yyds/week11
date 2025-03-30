package com.example.exercise11;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;
    private DataProvider dataProvider;
    private List<String> dataList;
    private List<String> filteredList;
    private SearchView searchView;
    private Button btnStartSearch;
    private int currentTab = 0;
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;
    private PlayerRepository playerRepository;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        btnStartSearch = findViewById(R.id.btn_startSearch);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewAdapter = new ViewAdapter(filteredList);
        recyclerView.setAdapter(viewAdapter);

        dataProvider = new DataProvider();
        teamRepository = new TeamRepository();
        matchRepository = new MatchRepository();
        playerRepository = new PlayerRepository();

        dataList = new ArrayList<>();
        filteredList = new ArrayList<>();
        loadTeamData();
        Button btnTeams = findViewById(R.id.btn_teams);
        Button btnPlayers = findViewById(R.id.btn_players);
        Button btnMatches = findViewById(R.id.btn_matches);

        btnTeams.setOnClickListener(v -> {
            currentTab = 0;
            loadTeamData();
        });

        btnPlayers.setOnClickListener(v -> {
            currentTab = 1;
            loadPlayerData();
        });

        btnMatches.setOnClickListener(v -> {
            currentTab = 2;
            loadMatchData();
        });

        btnStartSearch.setOnClickListener(v -> {
            searchView.setEnabled(true);
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                updateData();
                return true;
            }
            public boolean onQueryTextChange(String newText) {
                updateData();
                return true;
            }
        });
    }

    private void loadTeamData() {
        dataList.clear();
        for (Team team : dataProvider.team) {
            dataList.add(team.getName() + " - " + team.getCountry());
        }
        viewAdapter.updateData(dataList);
    }

    private void loadMatchData() {
        dataList.clear();
        for (Match match : dataProvider.match) {
            dataList.add(match.getHomeTeam() + " vs " + match.getAwayTeam() + " - " + match.getScore());
        }
        viewAdapter.updateData(dataList);
    }

    private void loadPlayerData() {
        dataList.clear();
        for (Player player : dataProvider.player) {
            dataList.add(player.getName() + " (" + player.getTeam() + ")");
        }
        viewAdapter.updateData(dataList);
    }

    private void sfilter(String query) {
        if (query == null) query = "";
        filteredList.clear();
        teamRepository.clear();
        matchRepository.clear();
        playerRepository.clear();

        switch (currentTab) {
            case 0:
                for (Team team : dataProvider.team){
                    teamRepository.add(team);
                }
                List<Team> teams = teamRepository.filterByLeague(query);
                for (Team team : teams) {
                    filteredList.add(team.getName() + " - " + team.getCountry());
                }
                viewAdapter.updateData(filteredList);
                break;
            case 2:
                for (Match match :dataProvider.match){
                    matchRepository.add(match);
                }
                List<Match> matches = matchRepository.filterByhomeTeam(query);
                for (Match match : matches) {
                    filteredList.add(match.getHomeTeam() + " vs " + match.getAwayTeam());
                }
                viewAdapter.updateData(filteredList);
                break;
            case 1:
                for (Player player :dataProvider.player){
                    playerRepository.add(player);
                }
                List<Player> players = playerRepository.filterByTeam(query);
                for (Player player : players) {
                    filteredList.add(player.getName() + " (" + player.getTeam() + ")");
                }
                viewAdapter.updateData(filteredList);
                break;
        }
    }

    private void updateData() {
        String query = searchView.getQuery().toString();
        sfilter(query);
    }
}















