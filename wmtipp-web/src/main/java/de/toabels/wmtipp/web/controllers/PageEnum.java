/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.toabels.wmtipp.web.controllers;

/**
 *
 * @author Torsten Abels <torsten.abels@gmail.com>
 */
public enum PageEnum {
    LIST_FOOTBALLDATA("/lists/footballDataResultList.jsf"),
    LIST_PLAYERRANKING("/lists/playerRanking.jsf"),
    LIST_SCHEDULE("/lists/schedule.jsf"),
    EDIT_COMMUNITY("/masterdata/editCommunity.jsf"),
    EDIT_COMPETITION("/masterdata/editCompetition.jsf"),
    EDIT_GROUP("/masterdata/editGroup.jsf"),
    EDIT_MATCH("/masterdata/editMatch.jsf"),
    EDIT_PLAYER("/masterdata/editPlayer.jsf"),
    EDIT_ROUND("/masterdata/editRound.jsf"),
    EDIT_TEAM("/masterdata/editTeam.jsf"),
    EDIT_TIPS("/masterdata/editTips.jsf");

    private String outcome;

    PageEnum(String outcome) {
        this.outcome = outcome;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

}
