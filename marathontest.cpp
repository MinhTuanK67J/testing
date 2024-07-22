#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

struct Athlete {
    std::string name;
    std::string date;
    std::string time;
    int ranking;
};

// Function to check if a date is within the qualifying period
bool is_within_qualifying_period(const std::string& date) {
    std::string qualifying_period_start = "2022-11-01";
    std::string qualifying_period_end = "2024-04-30";
    return qualifying_period_start <= date && date <= qualifying_period_end;
}

// Function to filter athletes by time
std::vector<Athlete> filter_by_time(const std::vector<Athlete>& athletes, const std::string& time_threshold) {
    std::vector<Athlete> qualified_by_time;
    for (const auto& athlete : athletes) {
        if (athlete.time < time_threshold && is_within_qualifying_period(athlete.date)) {
            qualified_by_time.push_back(athlete);
        }
    }
    return qualified_by_time;
}

// Function to filter athletes by ranking
std::vector<Athlete> filter_by_ranking(const std::vector<Athlete>& athletes, const std::vector<Athlete>& qualified_by_time) {
    std::vector<Athlete> qualified_by_ranking;
    int rank_limit = 65;
    int current_rank = 1;
    while (qualified_by_ranking.size() < rank_limit && current_rank <= athletes.size()) {
        const auto& athlete = athletes[current_rank - 1];
        auto it = std::find_if(qualified_by_time.begin(), qualified_by_time.end(), [&](const Athlete& a) {
            return a.name == athlete.name;
        });
        if (it == qualified_by_time.end() && is_within_qualifying_period(athlete.date)) {
            qualified_by_ranking.push_back(athlete);
        }
        current_rank++;
    }
    return qualified_by_ranking;
}

int main() {
    std::vector<Athlete> athletes_list;
    // Input athletes_list (this is just an example, the actual input method can vary)
    // For demonstration, you can manually populate the list as follows:
    athletes_list.push_back({"John Doe", "2023-05-10", "2:07:30", 1});
    athletes_list.push_back({"Jane Doe", "2023-06-15", "2:09:00", 2});
    
    // Sort athletes_list by ranking
    std::sort(athletes_list.begin(), athletes_list.end(), [](const Athlete& a, const Athlete& b) {
        return a.ranking < b.ranking;
    });
    
    std::string time_threshold = "2:08:10";
    
    // Get qualified athletes by time
    std::vector<Athlete> qualified_by_time = filter_by_time(athletes_list, time_threshold);
    
    // Get qualified athletes by ranking
    std::vector<Athlete> qualified_by_ranking = filter_by_ranking(athletes_list, qualified_by_time);
    
    // Output qualified_by_time
    std::cout << "Qualified by Time:" << std::endl;
    for (const auto& athlete : qualified_by_time) {
        std::cout << athlete.name << " " << athlete.date << " " << athlete.time << " " << athlete.ranking << std::endl;
    }
    
    // Output qualified_by_ranking
    std::cout << "Qualified by Ranking:" << std::endl;
    for (const auto& athlete : qualified_by_ranking) {
        std::cout << athlete.name << " " << athlete.date << " " << athlete.time << " " << athlete.ranking << std::endl;
    }
    
    return 0;
}
